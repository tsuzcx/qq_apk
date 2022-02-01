package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class EmoticonPanelMallHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
  implements EmoticonPackageChangedListener
{
  private static final String LOG_TAG = "EmoticonPanelMallHelper";
  private static final long MARKET_OPEN_INTERVAL = 2592000000L;
  EmoticonPackageDownloadListener downloadListener = new EmoticonPanelMallHelper.4(this);
  boolean isClickNoChangeTab = false;
  private boolean mAutoOpenPage = false;
  private int mFromType = 0;
  private boolean mOnItemClicked = false;
  AdapterView.OnItemClickListener tabItemClickListener = new EmoticonPanelMallHelper.6(this);
  
  public EmoticonPanelMallHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void asyncInitPanelDataList(boolean paramBoolean, EmoticonPanelController.PanelDataCallback paramPanelDataCallback)
  {
    QLog.d("EmoticonPanelMallHelper", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonPanelMallHelper.1(this, paramBoolean, paramPanelDataCallback), 5, null, true);
  }
  
  int findTabIndexByEpId(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, String paramString, List<EmotionPanelInfo> paramList)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int k = 0;
    int j = k;
    if (!bool)
    {
      if (paramQQEmoticonMainPanelApp == null) {
        return 0;
      }
      j = k;
      if (paramList != null)
      {
        paramQQEmoticonMainPanelApp = ((EmoticonManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramString);
        if ((paramQQEmoticonMainPanelApp != null) && ((paramQQEmoticonMainPanelApp.jobType == 3) || (paramQQEmoticonMainPanelApp.jobType == 5))) {
          j = 1;
        } else {
          j = 0;
        }
        int m = paramList.size();
        int i = 0;
        while (i < m)
        {
          paramQQEmoticonMainPanelApp = (EmotionPanelInfo)paramList.get(i);
          if (((paramQQEmoticonMainPanelApp != null) && (paramQQEmoticonMainPanelApp.emotionPkg != null) && (paramString.equals(paramQQEmoticonMainPanelApp.emotionPkg.epId))) || ((j != 0) && (paramQQEmoticonMainPanelApp != null) && (paramQQEmoticonMainPanelApp.type == 9))) {
            break label166;
          }
          i += 1;
        }
        i = -1;
        label166:
        j = k;
        if (i != -1) {
          j = i;
        }
      }
    }
    return j;
  }
  
  public int getEmoticonTab(String paramString, List<EmotionPanelInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (EmotionPanelInfo)paramList.get(i);
        if (((EmotionPanelInfo)localObject).type == 6)
        {
          localObject = ((EmotionPanelInfo)localObject).emotionPkg;
          if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
          {
            if (paramBoolean) {
              return i - 3;
            }
            return i - 2;
          }
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public int getFromType()
  {
    return this.mFromType;
  }
  
  public String getTag()
  {
    return "EmoticonPanelMallHelper";
  }
  
  @NotNull
  protected String getTalkBackWordingAndReportEvent(View paramView, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmotionPanelInfo paramEmotionPanelInfo)
  {
    int i = paramEmotionPanelInfo.type;
    boolean bool = true;
    Object localObject3 = "";
    Object localObject1;
    Object localObject2;
    if (i == 8)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131902115);
      paramView = (ImageView)paramView.findViewById(2131444541);
      if (paramView != null)
      {
        if (paramView.getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramView.setVisibility(8);
      }
      else
      {
        bool = false;
      }
      paramView = paramQQEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      paramView.edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      i = paramView.getInt("recommendRuleId", -1);
      localObject1 = paramQQEmoticonMainPanelApp.getCurrentUin();
      if (bool) {
        paramView = "1";
      } else {
        paramView = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      VasWebviewUtil.a((String)localObject1, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", paramView, "", ((StringBuilder)localObject2).toString(), "", 0, 0, 0, 0);
      localObject3 = "0X800AE0B";
      localObject2 = "";
      paramView = (View)localObject2;
      bool = false;
      localObject1 = "0X8005798";
    }
    else if (paramEmotionPanelInfo.type == 9)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131902104);
      localObject1 = "0X8005797";
      localObject3 = "0X800AE0D";
      localObject2 = "";
      paramView = "";
      label248:
      bool = false;
    }
    else
    {
      if (paramEmotionPanelInfo.type == 4)
      {
        paramEmotionPanelInfo = HardCodeUtil.a(2131902077);
        ReportController.b(paramQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        ((EmoticonPanelFavHelper)((EmoticonPanelController)this.mPanelController).getHelper(2)).doSyncFavEmotion();
        paramView = "0X800AE08";
        localObject1 = "0X8005799";
        label321:
        localObject2 = paramView;
        paramView = "";
      }
      for (;;)
      {
        Object localObject4 = paramView;
        localObject3 = localObject2;
        localObject2 = paramView;
        paramView = (View)localObject4;
        break label741;
        if (paramEmotionPanelInfo.type == 7)
        {
          paramEmotionPanelInfo = HardCodeUtil.a(2131902123);
          paramView = "0X800AE07";
          localObject1 = "0X800579A";
          break label321;
        }
        if (paramEmotionPanelInfo.type == 6)
        {
          paramEmotionPanelInfo = paramEmotionPanelInfo.emotionPkg;
          if (paramEmotionPanelInfo != null)
          {
            localObject2 = paramEmotionPanelInfo.epId;
            if (paramEmotionPanelInfo.status == 2) {
              paramView = "0X800584E";
            } else {
              paramView = "0X80059B8";
            }
            localObject1 = Integer.toString(((EmoticonPanelController)this.mPanelController).getEmoticonTab((String)localObject2));
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131902084));
            ((StringBuilder)localObject3).append(paramEmotionPanelInfo.name);
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131902101));
            localObject3 = ((StringBuilder)localObject3).toString();
            if (paramEmotionPanelInfo.status != 2)
            {
              paramEmotionPanelInfo = new StringBuilder();
              paramEmotionPanelInfo.append((String)localObject3);
              paramEmotionPanelInfo.append(HardCodeUtil.a(2131902125));
              localObject3 = paramEmotionPanelInfo.toString();
              paramEmotionPanelInfo = paramView;
              paramView = (View)localObject3;
            }
            else
            {
              paramEmotionPanelInfo = paramView;
              paramView = (View)localObject3;
            }
          }
          else
          {
            paramView = "";
            localObject2 = paramView;
            localObject1 = localObject2;
            paramEmotionPanelInfo = (EmotionPanelInfo)localObject3;
          }
          localObject3 = "0X800AE0C";
          localObject4 = localObject1;
          localObject1 = paramEmotionPanelInfo;
          paramEmotionPanelInfo = paramView;
          paramView = (View)localObject4;
          break label248;
        }
        if (paramEmotionPanelInfo.type == 11)
        {
          paramEmotionPanelInfo = HardCodeUtil.a(2131902124);
          paramView = (ImageView)paramView.findViewById(2131444541);
          if (paramView != null)
          {
            paramView.setVisibility(8);
            paramView = ((EmoticonPanelController)this.mPanelController).getInteractionListener();
            if ((paramView != null) && (paramView.getPanelicons() != null)) {
              paramView.setPaneliconsShowRed(3, false);
            }
          }
          ReportController.b(paramQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
          localObject2 = "0X800AE0A";
        }
        else
        {
          if (paramEmotionPanelInfo.type != 12) {
            break label702;
          }
          localObject2 = "0X800AE09";
          paramEmotionPanelInfo = "";
        }
        localObject1 = "";
        paramView = "";
        continue;
        label702:
        if (paramEmotionPanelInfo.type == 10)
        {
          localObject3 = "0X800AE0C";
          paramEmotionPanelInfo = "";
          localObject1 = paramEmotionPanelInfo;
          break;
        }
        paramEmotionPanelInfo = "";
        localObject1 = paramEmotionPanelInfo;
        localObject2 = localObject1;
        paramView = (View)localObject2;
      }
    }
    label741:
    i = ((EmoticonPanelController)this.mPanelController).getFromType(bool);
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i != 0)) {
      ReportController.b(paramQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", (String)localObject3, (String)localObject3, i, 0, "1", "", "", "");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ReportController.b(paramQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", (String)localObject1, 0, 0, (String)localObject2, "", paramView, "");
    }
    return paramEmotionPanelInfo;
  }
  
  public void initBefore()
  {
    EmojiListenerManager.a().a(this);
    EmojiListenerManager.a().addEmoticonPackageDownloadListener(this.downloadListener);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 7, 8, 1, 3 };
  }
  
  public void onDestory()
  {
    EmojiListenerManager.a().b(this);
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(this.downloadListener);
  }
  
  public void onPackageAdded(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (!TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPackageAdded: ep = ");
        localStringBuilder.append(paramEmoticonPackage);
        QLog.d("EmoticonPanelMallHelper", 2, localStringBuilder.toString());
      }
      ((EmoticonPanelController)this.mPanelController).getBasePanelView().mNeedUpdate = true;
      ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.7(this, paramEmoticonPackage));
      return;
    }
    QLog.e("EmoticonPanelMallHelper", 1, "onPackageAdded: ep = null");
  }
  
  public void onPackageDeleted(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageDeleted");
    }
    if (paramEmoticonPackage != null)
    {
      if (TextUtils.isEmpty(paramEmoticonPackage.epId)) {
        return;
      }
      List localList = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
      int i = 0;
      int k;
      for (int j = -1; i < localList.size(); j = k)
      {
        Object localObject = (EmotionPanelInfo)localList.get(i);
        k = j;
        if (localObject != null) {
          if (((EmotionPanelInfo)localObject).type != 6)
          {
            k = j;
            if (((EmotionPanelInfo)localObject).type != 10) {}
          }
          else
          {
            localObject = ((EmotionPanelInfo)localObject).emotionPkg;
            k = j;
            if (localObject != null)
            {
              k = j;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                k = i;
              }
            }
          }
        }
        i += 1;
      }
      if (j == -1) {
        return;
      }
      if (j < BasePanelModel.sLastSelectedSecondTabIndex)
      {
        paramEmoticonPackage = ((EmoticonPanelController)this.mPanelController).getBasePanelView();
        paramEmoticonPackage.mDeleteLeftPkgCount += 1;
      }
      else if ((j == BasePanelModel.sLastSelectedSecondTabIndex) && (j == localList.size() - 1))
      {
        ((EmoticonPanelController)this.mPanelController).getBasePanelView().mDeleteLeftPkgCount = (localList.size() - 1);
      }
      ((EmoticonPanelController)this.mPanelController).getBasePanelView().mNeedUpdate = true;
    }
  }
  
  public void onPackageMoved(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageMoved");
    }
    ((EmoticonPanelController)this.mPanelController).getBasePanelView().mNeedUpdate = true;
  }
  
  public void onPageSelected(int paramInt)
  {
    if (((EmoticonPanelController)this.mPanelController).getPanelDataList() != null)
    {
      if (paramInt >= ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()) {
        return;
      }
      if (((EmoticonPanelController)this.mPanelController).findIndexByPanelType(12) == paramInt)
      {
        Object localObject;
        if (((EmoticonPanelController)this.mPanelController).getPageAdapter() != null)
        {
          localObject = ((EmoticonPanelController)this.mPanelController).getPageAdapter().getAdapterFromCache((EmotionPanelInfo)((EmoticonPanelController)this.mPanelController).getPanelDataList().get(paramInt));
          if ((localObject instanceof EmotionHotPicSearchAdapter)) {
            ((EmotionHotPicSearchAdapter)localObject).clearReportedMD5List();
          }
        }
        if ((!this.mOnItemClicked) && (!this.mAutoOpenPage))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPageSelected position: ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.d("EmoticonPanelMallHelper", 2, ((StringBuilder)localObject).toString());
          }
          this.mFromType = 2;
          this.mOnItemClicked = false;
          reportPageEvent((EmotionPanelInfo)((EmoticonPanelController)this.mPanelController).getPanelDataList().get(paramInt), false);
          return;
        }
        this.mOnItemClicked = false;
        this.mAutoOpenPage = false;
      }
    }
  }
  
  public void onPause()
  {
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(this.downloadListener);
  }
  
  public void onResume()
  {
    EmojiListenerManager.a().addEmoticonPackageDownloadListener(this.downloadListener);
  }
  
  public void preloadWebProcess()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonPanelMallHelper.3(this));
  }
  
  public void reportPageEvent(EmotionPanelInfo paramEmotionPanelInfo, boolean paramBoolean)
  {
    if (paramEmotionPanelInfo != null)
    {
      if (paramEmotionPanelInfo.type == 7) {
        paramEmotionPanelInfo = "0X800AE07";
      }
      boolean bool;
      for (;;)
      {
        bool = true;
        break;
        if ((paramEmotionPanelInfo.type != 5) && (paramEmotionPanelInfo.type != 4))
        {
          if (paramEmotionPanelInfo.type == 11)
          {
            paramEmotionPanelInfo = "0X800AE0A";
          }
          else
          {
            if (paramEmotionPanelInfo.type == 8) {
              paramEmotionPanelInfo = "0X800AE0B";
            }
            for (;;)
            {
              bool = false;
              break label148;
              if (paramEmotionPanelInfo.type == 9)
              {
                paramEmotionPanelInfo = "0X800AE0D";
              }
              else
              {
                if (paramEmotionPanelInfo.type == 12)
                {
                  paramEmotionPanelInfo = "0X800AE09";
                  break;
                }
                if ((paramEmotionPanelInfo.type != 6) && (paramEmotionPanelInfo.type != 10))
                {
                  paramEmotionPanelInfo = "";
                  break;
                }
                paramEmotionPanelInfo = "0X800AE0C";
              }
            }
          }
        }
        else {
          paramEmotionPanelInfo = "0X800AE08";
        }
      }
      label148:
      int i = ((EmoticonPanelController)this.mPanelController).getFromType(bool);
      if ((!TextUtils.isEmpty(paramEmotionPanelInfo)) && (i != 0))
      {
        BaseQQAppInterface localBaseQQAppInterface = ((EmoticonPanelController)this.mPanelController).app.getQQAppInterface();
        String str;
        if (paramBoolean) {
          str = "3";
        } else {
          str = "2";
        }
        ReportController.b(localBaseQQAppInterface, "dc00898", "", "", paramEmotionPanelInfo, paramEmotionPanelInfo, i, 0, str, "", "", "");
      }
      if (paramBoolean)
      {
        this.mAutoOpenPage = true;
        this.mFromType = 0;
      }
    }
  }
  
  public void updateLastEmoticonPanel()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.2(this), 200L);
  }
  
  public void updateMagicPanel()
  {
    if (!((EmoticonPanelController)this.mPanelController).getPanel().isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.5(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper
 * JD-Core Version:    0.7.0.1
 */