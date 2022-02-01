package dov.com.qq.im.ae.play;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.AEPath.PLAY.FILES;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.QIMSlidingTabView.TabIcon;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEPlayShowPart
  extends VideoStoryBasePart
  implements Observer
{
  public static final int ANIMATION_DURATION = 200;
  private static final String TAG = "AEPlayShowPart";
  private AEVideoStoryCaptureModeViewModel mCaptureModeViewModel;
  private AEMaterialManager mMidMaterialManager;
  private AEPlayShowMaterialManager mPsMaterialManager;
  private AEPituCameraUnit mUnit;
  private View progressView;
  private AEPlayShowTabView tabView;
  private View tvRetryBtn;
  private ViewGroup vgContainer;
  private ViewGroup vgNoData;
  private ViewPager viewPager;
  private PlayViewPagerAdapter viewPagerAdapter;
  private ViewStub vsNoData;
  
  public AEPlayShowPart(Activity paramActivity, ViewStub paramViewStub, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramViewStub, paramVideoStoryCapturePartManager);
    this.mUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.mPsMaterialManager = ((AEPlayShowMaterialManager)QIMManager.a().c(19));
    this.mMidMaterialManager = ((AEMaterialManager)QIMManager.a().c(18));
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.1(this));
    this.mPsMaterialManager.addObserver(this, 1);
    this.mMidMaterialManager.a(this, 116);
    initViewModel();
    preLoadWebView(null);
  }
  
  private void cancelProgressDialog()
  {
    if (this.progressView != null) {
      this.progressView.setVisibility(8);
    }
    if (this.vgNoData != null) {
      this.vgNoData.setVisibility(8);
    }
  }
  
  private String findTabNameById(String paramString)
  {
    Object localObject = this.viewPagerAdapter.getmCategoryList();
    if (localObject != null)
    {
      AEMaterialCategory localAEMaterialCategory;
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        localObject = ((List)localObject).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject).next();
          } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null));
          localIterator = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      } while ((localAEMaterialMetaData == null) || (paramString == null) || (!paramString.equals(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)));
      return localAEMaterialCategory.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private String getCurTabName()
  {
    ArrayList localArrayList = this.tabView.getDataList();
    int i = this.tabView.getCurIndex();
    if ((localArrayList != null) && (i < localArrayList.size())) {
      return ((QIMSlidingTabView.TabIcon)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private AEMaterialCategory getCurrentTabMaterial(String paramString)
  {
    Object localObject = this.viewPagerAdapter.getmCategoryList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject).next();
        if ((localAEMaterialCategory != null) && (paramString != null) && (paramString.equals(localAEMaterialCategory.b))) {
          return localAEMaterialCategory;
        }
      }
    }
    return null;
  }
  
  private int getPageScrollY()
  {
    if ((this.viewPagerAdapter != null) && (this.viewPagerAdapter.getCurrentPageView() != null)) {
      return this.viewPagerAdapter.getCurrentPageView().getScrollY();
    }
    return 0;
  }
  
  @NonNull
  private List<AEMaterialCategory> getPlayShowCategories()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.mPsMaterialManager.getPsCategoryList();
  }
  
  private String getPositionFlag(String paramString)
  {
    if ((this.mUnit != null) && (this.mUnit.a() != null) && (this.mUnit.a().getIntent() != null)) {
      return this.mUnit.a().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> getTabDataList(List<AEMaterialCategory> paramList)
  {
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      try
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.next();
          QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
          localTabIcon.jdField_a_of_type_JavaLangString = localAEMaterialCategory.b;
          localArrayList.add(localTabIcon);
        }
        paramList = localArrayList;
      }
      finally {}
    }
  }
  
  private String getTabIdByMaterialId(String paramString)
  {
    if (this.viewPagerAdapter != null)
    {
      Object localObject1 = this.viewPagerAdapter.getmCategoryList();
      if (localObject1 != null)
      {
        AEMaterialCategory localAEMaterialCategory;
        AEMaterialMetaData localAEMaterialMetaData;
        do
        {
          localObject1 = ((List)localObject1).iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject1).next();
              } while (localAEMaterialCategory == null);
              localObject2 = localAEMaterialCategory.jdField_a_of_type_JavaUtilList;
            } while (localObject2 == null);
            localObject2 = ((List)localObject2).iterator();
          }
          localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject2).next();
        } while ((localAEMaterialMetaData == null) || (paramString == null) || (!paramString.equals(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)));
        return localAEMaterialCategory.b;
      }
    }
    return "";
  }
  
  private void initNoDataView(List<AEMaterialCategory> paramList, List<QIMSlidingTabView.TabIcon> paramList1)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (CollectionUtils.isEmpty(paramList1)))
    {
      if (this.vgNoData == null)
      {
        this.vgNoData = ((ViewGroup)this.vsNoData.inflate());
        this.tvRetryBtn = this.vgNoData.findViewById(2131380167);
        this.tvRetryBtn.setOnClickListener(new AEPlayShowPart.9(this));
      }
      this.vgNoData.setVisibility(0);
    }
    while ((this.vgNoData == null) || (this.vgNoData.getVisibility() != 0)) {
      return;
    }
    this.vgNoData.setVisibility(8);
  }
  
  private void initViewModel()
  {
    this.mCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.mUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.mCaptureModeViewModel.a.observe(this.mUnit, new AEPlayShowPart.7(this));
    CameraOperationHelper.b().observe(this.mUnit, new AEPlayShowPart.8(this));
  }
  
  private void preLoadWebView(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "preLoadWebView, url=" + paramString);
    }
    Intent localIntent = new Intent(this.mActivity, PreloadWebService.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", paramString);
    }
    try
    {
      this.mActivity.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AEPlayShowPart", 2, "preLoadWebView, error=", paramString);
    }
  }
  
  private void refreshViews()
  {
    Object localObject1 = getPlayShowCategories();
    preLoadWebView(null);
    Object localObject2 = getTabDataList((List)localObject1);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      QLog.d("AEPlayShowPart", 2, "tabDataList size: " + ((ArrayList)localObject2).size());
      if (this.vgNoData != null) {
        this.vgNoData.setVisibility(8);
      }
      this.tabView.setVisibility(0);
      this.viewPager.setVisibility(0);
      String str1 = getCurTabName();
      int i = getPageScrollY();
      this.tabView.initTabItemsWithRedDot((ArrayList)localObject2);
      this.viewPagerAdapter.setCategoryList((List)localObject1);
      this.viewPagerAdapter.notifyDataSetChanged();
      localObject1 = getPositionFlag("KEY_CURRENT_SELECT_ID");
      Object localObject3 = getPositionFlag("KEY_CURRENT_TYPE");
      localObject2 = getPositionFlag("KEY_CURRENT_TAB");
      String str2 = getTabIdByMaterialId((String)localObject1);
      AEMaterialCategory localAEMaterialCategory = getCurrentTabMaterial(str2);
      localObject3 = new StringBuilder().append("chooseId: ").append((String)localObject1).append(" typeId: ").append((String)localObject3).append(" posTabName: ").append(str2).append(" isMaterial null: ");
      if (localAEMaterialCategory == null) {}
      for (boolean bool = true;; bool = false)
      {
        AEQLog.a("AEPlayShowPart", bool);
        if ((localAEMaterialCategory == null) || (!AECaptureMode.PLAY.name.equals(localObject2))) {
          break;
        }
        send(655364, new Object[] { str2, localObject1 });
        return;
      }
      scrollToSpecPos(str1, i);
      return;
    }
    QLog.d("AEPlayShowPart", 2, "no data.");
    this.tabView.setVisibility(8);
    this.viewPager.setVisibility(8);
    initNoDataView((List)localObject1, (List)localObject2);
  }
  
  private void scrollToSpecItemWithClick(String paramString1, String paramString2)
  {
    paramString1 = getCurrentTabMaterial(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
      if (paramString1 != null) {
        break label20;
      }
    }
    label20:
    label88:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= paramString1.size()) {
          break label88;
        }
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramString1.get(i);
        if ((localAEMaterialMetaData != null) && (paramString2 != null) && (paramString2.equals(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)))
        {
          paramString1 = this.viewPagerAdapter.getCurrentPageView();
          if (paramString1 == null) {
            break;
          }
          paramString1.scrollToPosWithClick(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void scrollToSpecPos(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEPlayShowPart.6(this, paramString, paramInt));
  }
  
  @TargetApi(12)
  private void showGirdAnimation()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.vgContainer, "alpha", new float[] { 0.0F, 1.0F }));
    localAnimatorSet.setDuration(200L).start();
  }
  
  private void showProgressDialog()
  {
    if (this.progressView == null)
    {
      this.progressView = LayoutInflater.from(this.mActivity).inflate(2131559683, this.vgContainer, false);
      this.vgContainer.addView(this.progressView);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.progressView.getLayoutParams();
      localLayoutParams.addRule(13);
      this.progressView.setLayoutParams(localLayoutParams);
    }
    this.progressView.setVisibility(0);
  }
  
  private void switchToTab(int paramInt)
  {
    this.tabView.onTabChecked(paramInt);
  }
  
  public void initAfterInflation(View paramView)
  {
    this.vgContainer = ((ViewGroup)paramView);
    this.tabView = ((AEPlayShowTabView)this.vgContainer.findViewById(2131373262));
    this.viewPager = ((ViewPager)this.vgContainer.findViewById(2131381780));
    this.vsNoData = ((ViewStub)this.vgContainer.findViewById(2131381785));
    this.tabView.setTabCheckListener(new AEPlayShowPart.2(this));
    this.viewPagerAdapter = new PlayViewPagerAdapter(this.mActivity, this.mPartManager, getPlayShowCategories());
    this.viewPager.setAdapter(this.viewPagerAdapter);
    this.viewPager.setOnPageChangeListener(new AEPlayShowPart.3(this));
    refreshViews();
  }
  
  public void initView() {}
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      AEQLog.b("AEPlayShowPart", "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      if (hasInflated()) {
        ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
      }
    }
    while (paramInt != 116) {
      return;
    }
    AEQLog.b("AEPlayShowPart", "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
    this.mPsMaterialManager.refresh();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEPlayShowGridAdapter.selectedMaterial = null;
    AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    if (this.mMidMaterialManager != null) {
      this.mMidMaterialManager.a(this);
    }
    if (this.mPsMaterialManager != null)
    {
      this.mPsMaterialManager.removeObserver(this);
      this.mPsMaterialManager.clearCategoryList();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    String str;
    Object localObject;
    if (paramInt == 655361) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
        if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
        {
          str = AEPath.PLAY.FILES.b + File.separator + paramVarArgs.jdField_a_of_type_JavaLangString;
          localObject = findTabNameById(paramVarArgs.jdField_a_of_type_JavaLangString);
          AEBaseReportParam.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
          AETemplateInfoFragment.jumpToMe(this.mActivity, (String)localObject, str, paramVarArgs.jdField_a_of_type_JavaLangString, paramVarArgs.f, paramVarArgs.i);
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 655362)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
        {
          paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
          if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
          {
            AEBaseReportParam.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            str = findTabNameById(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject = new Intent(this.mActivity, QQBrowserActivity.class);
            ((Intent)localObject).addFlags(536870912);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("url", paramVarArgs.q);
            ((Intent)localObject).putExtra("loc_play_show_tab_name", str);
            ((Intent)localObject).putExtra("loc_play_show_material_id", paramVarArgs.jdField_a_of_type_JavaLangString);
            ((Intent)localObject).putExtra("key_camera_material_name", paramVarArgs.i);
            ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(this.mActivity));
            this.mActivity.startActivity((Intent)localObject);
          }
        }
      }
      else if (paramInt == 655363)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
        {
          paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
          if (paramVarArgs.equals(AEPlayShowGridAdapter.selectedMaterial))
          {
            AEBaseReportParam.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(this.mActivity, paramVarArgs.r, null, null, 2083, null);
          }
        }
      }
      else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
      {
        ensureInflate();
        str = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
        if (this.tabView != null)
        {
          localObject = this.tabView.getDataList();
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < ((List)localObject).size())
            {
              QIMSlidingTabView.TabIcon localTabIcon = (QIMSlidingTabView.TabIcon)((List)localObject).get(paramInt);
              if ((localTabIcon != null) && (str.equals(localTabIcon.jdField_a_of_type_JavaLangString)))
              {
                switchToTab(paramInt);
                this.viewPager.post(new AEPlayShowPart.4(this, str, paramVarArgs));
                return;
              }
              paramInt += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart
 * JD-Core Version:    0.7.0.1
 */