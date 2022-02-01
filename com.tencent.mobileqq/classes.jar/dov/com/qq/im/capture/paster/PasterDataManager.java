package dov.com.qq.im.capture.paster;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.WeatherDataProvider;
import com.tencent.biz.qqstory.model.WeatherDataProvider.WeatherInfo;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.control.QIMAsyncManager;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.CityRes;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.InformationPasterChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PasterDataManager
  extends QIMAsyncManager
  implements DataProvider.DataUpdateListener<WeatherDataProvider.WeatherInfo>, LbsManager.POIListRequestCallback, IEventReceiver
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private WeatherDataProvider jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider;
  public LbsManager.POIListRequestSession a;
  private PasterDataManager.DoodleEmojiDownloadEventReceiver jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver;
  protected EditVideoDoodle.DoodleFacePanelAdapter a;
  DoodleEmojiManager.POIPostersRequestCallback jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = new PasterDataManager.2(this);
  protected InfomationFacePackage a;
  protected LocationFacePackage a;
  protected Runnable a;
  public CopyOnWriteArrayList<FacePackage> a;
  protected boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public PasterDataManager()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
  }
  
  private void a(WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    if (paramWeatherInfo != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.c = paramWeatherInfo.jdField_a_of_type_Int;
      if (paramWeatherInfo.jdField_a_of_type_JavaLangString != null)
      {
        paramWeatherInfo = paramWeatherInfo.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramWeatherInfo != null) && (paramWeatherInfo.length == 2))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.h = paramWeatherInfo[0];
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.i = paramWeatherInfo[1];
        }
        paramWeatherInfo = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
        while (paramWeatherInfo.hasNext())
        {
          InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramWeatherInfo.next();
          if (localItem.jdField_a_of_type_Int == 6)
          {
            localItem.j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.h;
            localItem.k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.i;
            localItem.c = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.c;
          }
        }
      }
    }
  }
  
  private void a(BasicLocation paramBasicLocation, boolean paramBoolean)
  {
    SLog.b("PasterDataManager", "requestPoiList");
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = LbsManager.a();
    }
    if (paramBoolean)
    {
      localLbsManager.a(localBasicLocation, null, this);
      return;
    }
    localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage != null) && (!paramString1.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g))) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage != null) && (!paramString2.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage != null) && (i != 0))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f = paramString2;
        paramString1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((LocationFacePackage.Item)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.f = paramString2;
          paramString1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)paramString1.next();
            if (localItem.jdField_a_of_type_Boolean) {
              localItem.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (InfomationFacePackage.Item)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g.equals(paramString2.i)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, InfomationFacePackage.CityRes>> paramMap, String paramString, InfomationFacePackage.Item paramItem)
  {
    if (paramItem.a() != null) {
      paramItem.a().c();
    }
    Map localMap = (Map)paramMap.get(paramItem.h);
    if (localMap != null)
    {
      paramMap = (InfomationFacePackage.CityRes)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (InfomationFacePackage.CityRes)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        paramItem.g = paramMap.jdField_a_of_type_JavaLangString;
        paramItem.e = paramMap.jdField_b_of_type_JavaLangString;
        paramItem.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private void b()
  {
    Object localObject = (DoodleEmojiManager)SuperManager.a(39);
    ((DoodleEmojiManager)localObject).c();
    String str;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = new LocationFacePackage("0");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_Boolean = true;
      str = DoodleEmojiManager.c((DoodleEmojiManager)localObject, "0");
      localObject = DoodleEmojiManager.a((DoodleEmojiManager)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label110;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.a(str);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage = new InfomationFacePackage("2001");
      }
      return;
      label110:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846957);
    }
  }
  
  private static void b(NormalFacePackage paramNormalFacePackage, DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramNormalFacePackage.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    paramNormalFacePackage.c = paramDoodleEmojiItem.icon;
    paramNormalFacePackage.d = paramDoodleEmojiItem.download_icon;
    paramNormalFacePackage.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    paramNormalFacePackage.e = paramDoodleEmojiItem.download_wording;
    paramNormalFacePackage.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    paramNormalFacePackage.a(paramDoodleEmojiItem.config);
    paramNormalFacePackage.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    paramNormalFacePackage.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  public EditVideoDoodle.DoodleFacePanelAdapter a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter;
  }
  
  public FacePackage a(String paramString)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f;
    }
    return null;
  }
  
  public List<FacePackage> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<FacePackage> a(boolean paramBoolean)
  {
    for (;;)
    {
      DoodleEmojiItem localDoodleEmojiItem;
      Object localObject3;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
          break label752;
        }
        Object localObject1 = ((DoodleEmojiManager)SuperManager.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new NormalFacePackage(localDoodleEmojiItem.pack_id);
          b((NormalFacePackage)localObject3, localDoodleEmojiItem);
          if (("1".equals(((NormalFacePackage)localObject3).jdField_a_of_type_JavaLangString)) && (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((NormalFacePackage)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846814);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        SLog.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (LocationFacePackage.Item)((Iterator)localObject3).next();
          ((LocationFacePackage.Item)localObject4).g = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_JavaLangString;
          ((LocationFacePackage.Item)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.f;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846957);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage == null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage = new InfomationFacePackage(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g = "default";
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.c = -999;
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.h = "--";
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.i = "default";
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (InfomationFacePackage.Item)((Iterator)localObject3).next();
            ((InfomationFacePackage.Item)localObject4).m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_b_of_type_JavaLangString;
            if (InformationFaceConstant.a(((InfomationFacePackage.Item)localObject4).jdField_a_of_type_Int)) {
              ((InfomationFacePackage.Item)localObject4).l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((InfomationFacePackage.Item)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g, (InfomationFacePackage.Item)localObject4);
            }
            if (((InfomationFacePackage.Item)localObject4).jdField_a_of_type_Int == 6)
            {
              ((InfomationFacePackage.Item)localObject4).c = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.c;
              ((InfomationFacePackage.Item)localObject4).j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.h;
              ((InfomationFacePackage.Item)localObject4).k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.i;
            }
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    SLog.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    label752:
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
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List<TroopBarPOI> paramList)
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
        String str = ShortVideoUtils.getRecentPOI(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramPOIListRequestSession = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramPOIListRequestSession, true);
      return;
    }
  }
  
  public void a(BasicLocation paramBasicLocation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider = ((WeatherDataProvider)((DataProviderManager)SuperManager.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.a();
    if (localObject != null)
    {
      SLog.b("PasterDataManager", "get weather from cache.");
      a((WeatherDataProvider.WeatherInfo)localObject);
      return;
    }
    SLog.b("PasterDataManager", "get weather from net.");
    localObject = paramBasicLocation;
    if (paramBasicLocation == null) {
      localObject = LbsManager.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.b((BasicLocation)localObject);
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage != null) && (!"default".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.g)) && (!"--".equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage.h))) {
      return;
    }
    new LocationPermissionHelper(paramActivity, new PasterDataManager.3(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, WeatherDataProvider.WeatherInfo paramWeatherInfo)
  {
    if (paramBoolean) {
      a(paramWeatherInfo);
    }
  }
  
  public void initIndeed()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle$DoodleFacePanelAdapter = new EditVideoDoodle.DoodleFacePanelAdapter();
    b();
    this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = new PasterDataManager.DoodleEmojiDownloadEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver != null)
    {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver);
      this.jdField_a_of_type_DovComQqImCapturePasterPasterDataManager$DoodleEmojiDownloadEventReceiver = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelWeatherDataProvider.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterDataManager
 * JD-Core Version:    0.7.0.1
 */