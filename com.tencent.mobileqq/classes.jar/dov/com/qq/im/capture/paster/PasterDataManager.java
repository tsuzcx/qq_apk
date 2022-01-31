package dov.com.qq.im.capture.paster;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anmv;
import anmw;
import anmx;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PasterDataManager
  extends IQIMManager
  implements LbsManager.POIListRequestCallback, IEventReceiver
{
  public static AtomicBoolean a;
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public LbsManager.POIListRequestSession a;
  private PasterDataManager.DoodleEmojiDownloadEventReceiver jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver;
  protected EditVideoDoodle.DoodleFacePanelAdapter a;
  public DoodleEmojiManager.POIPostersRequestCallback a;
  protected InfomationFacePackage a;
  protected LocationFacePackage a;
  public Runnable a;
  public CopyOnWriteArrayList a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public PasterDataManager()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = null;
    this.jdField_a_of_type_JavaLangRunnable = new anmv(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new anmw(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage != null) && (!paramString.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f = paramString;
          localIterator = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            ((LocationFacePackage.Item)localIterator.next()).jdField_b_of_type_JavaLangString = paramString;
          }
          if (paramBoolean) {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
          }
        }
      } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage == null) || (paramString.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.f)));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.f = paramString;
      Iterator localIterator = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)localIterator.next();
        if (localItem.jdField_a_of_type_Boolean) {
          localItem.g = paramString;
        }
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage);
  }
  
  private void f()
  {
    Object localObject = (DoodleEmojiManager)SuperManager.a(36);
    ((DoodleEmojiManager)localObject).a(BaseApplicationImpl.getApplication());
    String str;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = new LocationFacePackage("0");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_Boolean = true;
      str = DoodleEmojiManager.c((DoodleEmojiManager)localObject, "0");
      localObject = DoodleEmojiManager.a((DoodleEmojiManager)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label112;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(str);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage = new InfomationFacePackage("9999999");
      }
      return;
      label112:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843550);
    }
  }
  
  public EditVideoDoodle.DoodleFacePanelAdapter a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter;
  }
  
  public FacePackage a(String paramString)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(paramString);
  }
  
  public Collection a()
  {
    return a(false);
  }
  
  @NonNull
  public Collection a(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
          break label710;
        }
        Object localObject1 = ((DoodleEmojiManager)SuperManager.a(36)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (DoodleEmojiItem)((Iterator)localObject1).next();
        SLog.b("PasterDataManager", "add doodle emoji item = " + localObject3);
        if (((DoodleEmojiItem)localObject3).type == 1)
        {
          localObject4 = new NormalFacePackage(((DoodleEmojiItem)localObject3).pack_id);
          ((NormalFacePackage)localObject4).jdField_b_of_type_JavaLangString = ((DoodleEmojiItem)localObject3).name;
          ((NormalFacePackage)localObject4).c = ((DoodleEmojiItem)localObject3).icon;
          ((NormalFacePackage)localObject4).d = ((DoodleEmojiItem)localObject3).download_icon;
          ((NormalFacePackage)localObject4).g = ((DoodleEmojiItem)localObject3).getLocalEmojiFolderPath();
          ((NormalFacePackage)localObject4).e = ((DoodleEmojiItem)localObject3).download_wording;
          ((NormalFacePackage)localObject4).jdField_a_of_type_Boolean = "1".equals(((DoodleEmojiItem)localObject3).random_position);
          ((NormalFacePackage)localObject4).a(((DoodleEmojiItem)localObject3).config);
          ((NormalFacePackage)localObject4).jdField_a_of_type_Int = ((DoodleEmojiItem)localObject3).hide;
          ((NormalFacePackage)localObject4).jdField_b_of_type_Int = ((DoodleEmojiItem)localObject3).mask;
          if (("1".equals(((NormalFacePackage)localObject4).jdField_a_of_type_JavaLangString)) && (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((NormalFacePackage)localObject4).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843426);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject4);
          continue;
        }
        if (((DoodleEmojiItem)localObject3).type != 2) {
          break label502;
        }
      }
      finally {}
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString = ((DoodleEmojiItem)localObject3).name;
      if ((!TextUtils.isEmpty(((DoodleEmojiItem)localObject3).icon)) && (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((DoodleEmojiItem)localObject3).icon;
      }
      while (((DoodleEmojiItem)localObject3).mItemList != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_JavaUtilList = ((DoodleEmojiItem)localObject3).mItemList;
        if (((DoodleEmojiItem)localObject3).mItemList == null) {
          break;
        }
        SLog.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f);
        localObject4 = ((DoodleEmojiItem)localObject3).mItemList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          LocationFacePackage.Item localItem = (LocationFacePackage.Item)((Iterator)localObject4).next();
          localItem.g = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString;
          localItem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843550);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Boolean = "1".equals(((DoodleEmojiItem)localObject3).random_position);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Int = ((DoodleEmojiItem)localObject3).hide;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_Int = ((DoodleEmojiItem)localObject3).mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
      continue;
      label502:
      if (((DoodleEmojiItem)localObject3).type == 3)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage = new InfomationFacePackage(((DoodleEmojiItem)localObject3).pack_id);
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_b_of_type_JavaLangString = ((DoodleEmojiItem)localObject3).name;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList = ((DoodleEmojiItem)localObject3).mInfoItemList;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.a(((DoodleEmojiItem)localObject3).config);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_Int = ((DoodleEmojiItem)localObject3).hide;
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList != null)
        {
          localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (InfomationFacePackage.Item)((Iterator)localObject3).next();
            ((InfomationFacePackage.Item)localObject4).h = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_b_of_type_JavaLangString;
            if (InformationFaceConstant.a(((InfomationFacePackage.Item)localObject4).jdField_a_of_type_Int)) {
              ((InfomationFacePackage.Item)localObject4).g = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.f;
            }
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage);
      }
    }
    SLog.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    label710:
    if (paramBoolean)
    {
      StaticStickerProviderView.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter = new EditVideoDoodle.DoodleFacePanelAdapter();
    f();
    Dispatcher localDispatcher = Dispatchers.get();
    PasterDataManager.DoodleEmojiDownloadEventReceiver localDoodleEmojiDownloadEventReceiver = new PasterDataManager.DoodleEmojiDownloadEventReceiver(this);
    this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = localDoodleEmojiDownloadEventReceiver;
    localDispatcher.registerSubscriber(localDoodleEmojiDownloadEventReceiver);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    SLog.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramPOIListRequestSession != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramPOIListRequestSession = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramPOIListRequestSession);
        }
        a(paramPOIListRequestSession, true);
      }
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Int & paramInt) != 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver != null)
    {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver);
      this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = null;
    }
  }
  
  public void c()
  {
    a(true);
  }
  
  public void d()
  {
    SosoInterface.a(new anmx(this, "NewStoryTakeVideoActivity"));
  }
  
  public void e()
  {
    SLog.b("PasterDataManager", "requestPoiList");
    ((LbsManager)SuperManager.a(9)).a(LbsManager.a(), this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, this);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterDataManager
 * JD-Core Version:    0.7.0.1
 */