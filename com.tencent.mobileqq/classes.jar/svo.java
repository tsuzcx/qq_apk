import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

@TargetApi(14)
public class svo
  extends sxe<sxh>
  implements IEventReceiver
{
  private svz jdField_a_of_type_Svz;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        aukn localaukn = QQStoryContext.a().a().createEntityManager();
        svo localsvo = (svo)tdc.a(3);
        localList = localaukn.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
          i = 0;
          return i;
        }
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label288;
        }
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
        long l1 = localPublishVideoEntry.getId();
        String str1 = localPublishVideoEntry.fakeVid;
        int j = localPublishVideoEntry.publishState;
        String str2 = localPublishVideoEntry.videoLabel;
        String str3 = localPublishVideoEntry.videoDoodleDescription;
        long l2 = localPublishVideoEntry.videoDuration;
        String str4 = localPublishVideoEntry.videoLocationDescription;
        if (localPublishVideoEntry.isPicture)
        {
          i = 1;
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localaukn.a(localPublishVideoEntry);
          localsvo.a(localPublishVideoEntry);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label288:
      int i = localList.size();
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      swa.a().a();
    }
    sxh localsxh = new sxh(paramPublishVideoEntry);
    super.b(localsxh);
    svy localsvy;
    if (!localsxh.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      swa.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localsvy = new svy(true);
      if (localsxh.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localsvy.jdField_b_of_type_Boolean = bool1;
      localObject1 = (tcz)tdc.a(5);
      Object localObject2 = localsxh.a();
      localsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcz)localObject1).a(localsxh.a(), (StoryVideoItem)localObject2);
      localsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localsxh.a();
      localObject1 = localsxh.a();
      if ((localObject1 == null) || (((tet)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localsvy.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((tet)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new svx();
        ((svx)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uwa.a((String)localObject3, localsxh.a().mLocalDate);
        ((svx)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new svw();
        ((svw)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((svx)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localsvy.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
      bool1 = false;
      break;
    }
    label297:
    bool1 = paramPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
    boolean bool2 = paramPublishVideoEntry.isLocalPublish;
    if ((bool1) || (bool2))
    {
      int i = Math.min(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      int j = Math.max(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      paramPublishVideoEntry.videoWidth = i;
      paramPublishVideoEntry.videoHeight = j;
      if ((tcv.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (tcv.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((aukn)localObject1).b(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localsxh, localsvy), 8, new svs(this, localsxh), false);
  }
  
  public static void a(String paramString)
  {
    ((svo)tdc.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (tcv)tdc.a(10);
      boolean bool1 = ((Boolean)((tcv)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((tcv)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = vst.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        vyi.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new tbs(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().b(paramString);
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      veg.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      vxs.a(paramString);
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      tcz localtcz = (tcz)tdc.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localtcz.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = uwa.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (vzo.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((tdo)tdc.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localtcz.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    ste.a().dispatch(new svv());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
      a(paramString, paramList, 1);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void a(String paramString, List<StoryVideoItem> paramList, int paramInt)
  {
    for (;;)
    {
      VideoListFeedItem localVideoListFeedItem;
      tcz localtcz;
      Object localObject5;
      try
      {
        localVideoListFeedItem = uwa.a(paramString, uwa.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localtcz = (tcz)tdc.a(5);
        localObject1 = new svy(true);
        ((svy)localObject1).jdField_b_of_type_Boolean = false;
        ((svy)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new svx();
        ((svy)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((svx)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new svw();
          ((svw)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localtcz.a((StoryVideoItem)localObject4);
          ((svx)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        ste.a().dispatch((Dispatcher.Dispatchable)localObject1);
      }
      finally {}
      Object localObject1 = new ArrayList(paramList.size());
      Object localObject2 = new ArrayList(paramList.size());
      Object localObject3 = new ArrayList(paramList.size());
      Object localObject4 = paramList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (StoryVideoItem)((Iterator)localObject4).next();
        ((ArrayList)localObject1).add(((StoryVideoItem)localObject5).sourceVid);
        ((ArrayList)localObject2).add(Long.valueOf(((StoryVideoItem)localObject5).mCreateTime));
        ((ArrayList)localObject3).add(Integer.valueOf((int)((StoryVideoItem)localObject5).mTimeZoneOffsetMillis / 1000));
      }
      paramString = new tls(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      syr.a().a(paramString, new svq(localVideoListFeedItem, paramList, localtcz));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bbev.g(paramActivity)) {
      bcpw.a(paramActivity, 1, ajyc.a(2131714560), 0).a();
    }
    ArrayList localArrayList1;
    do
    {
      return;
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (!TextUtils.isEmpty(localStoryVideoItem.sourceVid))
        {
          localArrayList2.add(localStoryVideoItem);
        }
        else if (svy.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
        }
        else
        {
          a(localStoryVideoItem, paramActivity);
        }
      }
      if (localArrayList2.size() > 0) {
        a(((StoryVideoItem)localArrayList2.get(0)).shareGroupId, localArrayList2);
      }
    } while ((localArrayList1.size() <= 0) || (paramActivity.isFinishing()));
    paramList = bbcv.a(paramActivity, 230);
    paramList.setTitle(ajyc.a(2131714561));
    paramList.setMessage(ajyc.a(2131714563));
    paramList.setPositiveButton(ajyc.a(2131714562), new svp(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bbev.g(paramContext))
    {
      bcpw.a(paramContext, 1, ajyc.a(2131714559), 0).a();
      return false;
    }
    ((svo)tdc.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new svr("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    veg.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new svu(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(sxh paramsxh)
  {
    return new StoryVideoUploadTask(paramsxh);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Svz = new svz(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Svz);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (sxv.a(paramStoryVideoItem))
    {
      veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      swa.a().a();
    }
    sxh localsxh = new sxh(paramStoryVideoItem);
    localsxh.jdField_b_of_type_Int += 1;
    super.b(localsxh);
    Object localObject1;
    if (!localsxh.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      swa.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (tcz)tdc.a(5);
      paramStoryVideoItem = new svy(false);
      if (localsxh.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcz)localObject1).a(localsxh.a(), localsxh.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localsxh.a();
      localObject1 = localsxh.a();
      if ((localObject1 == null) || (((tet)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((tet)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        svx localsvx = new svx();
        localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uwa.a((String)localObject2, localsxh.a().mLocalDate);
        localsvx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new svw();
        ((svw)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localsvx.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localsvx);
      }
      bool = false;
      break;
    }
    label327:
    ste.a().dispatch(paramStoryVideoItem);
    super.d();
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localsxh });
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (sxh)((Iterator)localObject3).next();
      } while (!paramString1.equals(((sxh)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((sxh)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (sxh)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((sxh)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (tcz)tdc.a(5);
        localObject3 = ((sxh)localObject2).a();
        ((tcz)localObject1).a(((sxh)localObject2).a(), (StoryVideoItem)localObject3);
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(sxh paramsxh)
  {
    if (b()) {
      veg.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramsxh.b())
      {
        localObject1 = sum.a(paramsxh.jdField_g_of_type_JavaLangString, paramsxh.d, 0, false, false);
        if (!vyi.b(paramsxh.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramsxh.jdField_a_of_type_JavaLangString = ((String)localObject1);
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = sum.a(paramsxh.jdField_g_of_type_JavaLangString, paramsxh.d, 2, false, false);
        if (!vyi.b(paramsxh.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramsxh.jdField_c_of_type_JavaLangString = paramsxh.jdField_b_of_type_JavaLangString;
        paramsxh.jdField_b_of_type_JavaLangString = ((String)localObject1);
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramsxh.e))
        {
          localObject1 = sum.a(paramsxh.jdField_g_of_type_JavaLangString, paramsxh.d, 6, false, false);
          if (!vyi.b(paramsxh.e, (String)localObject1)) {
            break label964;
          }
          paramsxh.e = ((String)localObject1);
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramsxh.jdField_f_of_type_JavaLangString))
        {
          localObject1 = sum.a(paramsxh.jdField_g_of_type_JavaLangString, paramsxh.d, 6, false, false);
          if (!vyi.b(paramsxh.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramsxh.jdField_f_of_type_JavaLangString = ((String)localObject1);
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramsxh.m))
        {
          localObject1 = sum.a(paramsxh.jdField_g_of_type_JavaLangString, paramsxh.d, 5, false, false);
          if (!vyi.b(paramsxh.m, (String)localObject1)) {
            break label986;
          }
          paramsxh.m = ((String)localObject1);
          veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramsxh.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramsxh.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramsxh.a().getStringExtra("pk_comment_content", null);
            int i = paramsxh.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramsxh.a().getStringExtra("pk_vid", null);
            localObject4 = paramsxh.a().getStringExtra("post_pk_comment_style", null);
            szh.a((String)localObject1, (String)localObject2, i, paramsxh.jdField_g_of_type_JavaLangString, paramsxh.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (tcz)tdc.a(5);
      Object localObject2 = (uwa)tdc.a(11);
      Object localObject4 = ((tcz)localObject3).a(paramsxh.a(), paramsxh.a());
      veg.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new svy(false);
      boolean bool;
      Object localObject5;
      svx localsvx;
      svw localsvw;
      Object localObject6;
      tny localtny;
      if (!paramsxh.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((svy)localObject1).jdField_b_of_type_Boolean = bool;
        ((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramsxh.a();
        localObject4 = paramsxh.a();
        if ((localObject4 == null) || (((tet)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((svy)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((tet)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localsvx = new svx();
        localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uwa.a((String)localObject5, paramsxh.a().mLocalDate);
        localsvx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localsvw = new svw();
        localsvw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramsxh.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramsxh.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localtny = (tny)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localtny.jdField_a_of_type_JavaLangString)) {
              if ((!(localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localtny.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((uwa)localObject2).a(localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localtny.jdField_a_of_type_JavaUtilMap.get(paramsxh.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        vxs.a(((StoryVideoItem)localObject5).mVid);
        localsvw.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcz)localObject3).a((StoryVideoItem)localObject5);
        ((uwa)localObject2).a(localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((uwa)localObject2).a(localtny.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localsvx.jdField_a_of_type_JavaUtilArrayList.add(localsvw);
        ((svy)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localsvx);
        break label603;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localsvx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localtny.jdField_b_of_type_JavaLangString;
        vxs.a(localtny.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramsxh.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramsxh.jdField_a_of_type_Long;
        vel.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { vel.b(paramsxh.jdField_f_of_type_Int) + "", paramsxh.jdField_b_of_type_Long + "", "", paramsxh.jdField_g_of_type_Int + "" });
        if (bjil.c)
        {
          l1 = bjil.h.a[0] + l2;
          long l3 = bjil.h.a[1];
          bjil.h.a(2, l2 - l3);
          if (bjil.h.a())
          {
            l2 = bjil.h.a[0];
            l3 = bjil.h.a[1];
            long l4 = bjil.h.a[2];
            if ((vel.a(l1, 0L, 120000L)) && (vel.a(l2, 0L, 120000L)) && (vel.a(l3, 0L, 120000L)) && (vel.a(l4, 0L, 120000L))) {
              vel.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            bjil.h.c();
          }
        }
      }
      if ((paramsxh.jdField_a_of_type_Int == 5) || (paramsxh.jdField_a_of_type_Int == 3) || (paramsxh.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        vel.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramsxh.jdField_a_of_type_Long), new String[] { vel.b(paramsxh.jdField_f_of_type_Int) + "", paramsxh.jdField_b_of_type_Long + "", "", paramsxh.jdField_g_of_type_Int + "" });
      }
      if (((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((svy)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramsxh.a();
        ((svy)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramsxh.jdField_g_of_type_JavaLangString;
        ((svy)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcz)localObject3).a(paramsxh.jdField_g_of_type_JavaLangString, ((svy)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((svy)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((svy)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((uwa)localObject2).a(((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramsxh.jdField_b_of_type_Int > 0) {
          vel.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramsxh.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramsxh.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramsxh.jdField_a_of_type_Long;
        vel.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), vel.a(BaseApplication.getContext()), String.valueOf(paramsxh.jdField_b_of_type_Int) });
        vel.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), vel.a(BaseApplication.getContext()), String.valueOf(paramsxh.jdField_b_of_type_Int) });
        localObject2 = paramsxh.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        vel.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramsxh.h });
        veh.a(2444494, null);
        veg.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramsxh.a(), Long.valueOf(l1));
        swf.a(paramsxh.a());
      }
      if (((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        ste.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        vel.a("mystory", "publish_fail", 0, 0, new String[] { vel.b(paramsxh.jdField_f_of_type_Int) + "", paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramsxh.jdField_b_of_type_Int > 0) {
          vel.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramsxh.jdField_a_of_type_Long;
        localObject1 = String.format(paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramsxh.jdField_b_of_type_Int), Integer.valueOf(paramsxh.jdField_c_of_type_Int), paramsxh.a(), paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        vel.b("publish_story", "publish_all_old", 0, paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), vel.a(BaseApplication.getContext()), String.valueOf(paramsxh.jdField_b_of_type_Int) });
        if (!"composite".equals(paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          vel.b("publish_story", "publish_all", 0, paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), vel.a(BaseApplication.getContext()), String.valueOf(paramsxh.jdField_b_of_type_Int) });
        }
        localObject2 = paramsxh.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        vel.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramsxh.h });
        veh.a(2444493, paramsxh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        veg.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramsxh.a(), Long.valueOf(l1));
        return;
      }
    } while (((svy)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    ste.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(sxh paramsxh, ErrorMessage paramErrorMessage)
  {
    if (paramsxh.jdField_a_of_type_Int == 5) {
      swa.a().a(paramsxh.a(), paramsxh.jdField_g_of_type_JavaLangString);
    }
    while ((paramsxh.jdField_a_of_type_Int != 6) && (paramsxh.jdField_a_of_type_Int != 3) && (paramsxh.jdField_a_of_type_Int != 7)) {
      return;
    }
    swa.a().d(paramsxh.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	svo:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 742	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lsxf;
    //   16: checkcast 154	sxh
    //   19: invokevirtual 186	sxh:a	()Ljava/lang/String;
    //   22: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 734	svo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 451	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 84 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 88 1 0
    //   60: checkcast 154	sxh
    //   63: invokevirtual 186	sxh:a	()Ljava/lang/String;
    //   66: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq -27 -> 44
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -44 -> 32
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -49 -> 32
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	svo
    //   0	89	1	paramString	String
    //   25	56	2	bool	boolean
    //   6	49	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	84	finally
    //   11	26	84	finally
    //   36	44	84	finally
    //   44	70	84	finally
  }
  
  public void b()
  {
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Svz);
  }
  
  public void c(String paramString)
  {
    Object localObject = (tcz)tdc.a(5);
    StoryVideoItem localStoryVideoItem = ((tcz)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        vyi.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        vyi.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        vyi.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((tcz)localObject).a(paramString);
    localObject = new sxh(paramString);
    super.c((sxf)localObject);
    veg.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    swf.a(((sxh)localObject).a());
    Bosses.get().scheduleJobDelayed(new svt(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */