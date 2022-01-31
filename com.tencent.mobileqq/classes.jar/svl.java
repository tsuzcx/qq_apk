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
public class svl
  extends sxb<sxe>
  implements IEventReceiver
{
  private svw jdField_a_of_type_Svw;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        aukp localaukp = QQStoryContext.a().a().createEntityManager();
        svl localsvl = (svl)tcz.a(3);
        localList = localaukp.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
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
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localaukp.a(localPublishVideoEntry);
          localsvl.a(localPublishVideoEntry);
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
      svx.a().a();
    }
    sxe localsxe = new sxe(paramPublishVideoEntry);
    super.b(localsxe);
    svv localsvv;
    if (!localsxe.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      svx.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localsvv = new svv(true);
      if (localsxe.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localsvv.jdField_b_of_type_Boolean = bool1;
      localObject1 = (tcw)tcz.a(5);
      Object localObject2 = localsxe.a();
      localsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)localObject1).a(localsxe.a(), (StoryVideoItem)localObject2);
      localsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localsxe.a();
      localObject1 = localsxe.a();
      if ((localObject1 == null) || (((teq)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localsvv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((teq)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new svu();
        ((svu)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uvx.a((String)localObject3, localsxe.a().mLocalDate);
        ((svu)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new svt();
        ((svt)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((svu)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localsvv.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
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
      if ((tcs.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (tcs.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((aukp)localObject1).b(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localsxe, localsvv), 8, new svp(this, localsxe), false);
  }
  
  public static void a(String paramString)
  {
    ((svl)tcz.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (tcs)tcz.a(10);
      boolean bool1 = ((Boolean)((tcs)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((tcs)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = vsq.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        vyf.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new tbp(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().b(paramString);
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      vxp.a(paramString);
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      tcw localtcw = (tcw)tcz.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localtcw.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = uvx.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (vzl.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((tdl)tcz.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localtcw.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    stb.a().dispatch(new svs());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
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
      tcw localtcw;
      Object localObject5;
      try
      {
        localVideoListFeedItem = uvx.a(paramString, uvx.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localtcw = (tcw)tcz.a(5);
        localObject1 = new svv(true);
        ((svv)localObject1).jdField_b_of_type_Boolean = false;
        ((svv)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new svu();
        ((svv)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((svu)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new svt();
          ((svt)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localtcw.a((StoryVideoItem)localObject4);
          ((svu)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        stb.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new tlp(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      syo.a().a(paramString, new svn(localVideoListFeedItem, paramList, localtcw));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bbfj.g(paramActivity)) {
      bcql.a(paramActivity, 1, ajya.a(2131714571), 0).a();
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
        else if (svv.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
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
    paramList = bbdj.a(paramActivity, 230);
    paramList.setTitle(ajya.a(2131714572));
    paramList.setMessage(ajya.a(2131714574));
    paramList.setPositiveButton(ajya.a(2131714573), new svm(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bbfj.g(paramContext))
    {
      bcql.a(paramContext, 1, ajya.a(2131714570), 0).a();
      return false;
    }
    ((svl)tcz.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new svo("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    ved.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new svr(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(sxe paramsxe)
  {
    return new StoryVideoUploadTask(paramsxe);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Svw = new svw(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Svw);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (sxs.a(paramStoryVideoItem))
    {
      ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      svx.a().a();
    }
    sxe localsxe = new sxe(paramStoryVideoItem);
    localsxe.jdField_b_of_type_Int += 1;
    super.b(localsxe);
    Object localObject1;
    if (!localsxe.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      svx.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (tcw)tcz.a(5);
      paramStoryVideoItem = new svv(false);
      if (localsxe.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)localObject1).a(localsxe.a(), localsxe.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localsxe.a();
      localObject1 = localsxe.a();
      if ((localObject1 == null) || (((teq)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((teq)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        svu localsvu = new svu();
        localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uvx.a((String)localObject2, localsxe.a().mLocalDate);
        localsvu.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new svt();
        ((svt)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localsvu.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localsvu);
      }
      bool = false;
      break;
    }
    label327:
    stb.a().dispatch(paramStoryVideoItem);
    super.d();
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localsxe });
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
        localObject1 = (sxe)((Iterator)localObject3).next();
      } while (!paramString1.equals(((sxe)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((sxe)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (sxe)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((sxe)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (tcw)tcz.a(5);
        localObject3 = ((sxe)localObject2).a();
        ((tcw)localObject1).a(((sxe)localObject2).a(), (StoryVideoItem)localObject3);
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(sxe paramsxe)
  {
    if (b()) {
      ved.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramsxe.b())
      {
        localObject1 = suj.a(paramsxe.jdField_g_of_type_JavaLangString, paramsxe.d, 0, false, false);
        if (!vyf.b(paramsxe.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramsxe.jdField_a_of_type_JavaLangString = ((String)localObject1);
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = suj.a(paramsxe.jdField_g_of_type_JavaLangString, paramsxe.d, 2, false, false);
        if (!vyf.b(paramsxe.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramsxe.jdField_c_of_type_JavaLangString = paramsxe.jdField_b_of_type_JavaLangString;
        paramsxe.jdField_b_of_type_JavaLangString = ((String)localObject1);
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramsxe.e))
        {
          localObject1 = suj.a(paramsxe.jdField_g_of_type_JavaLangString, paramsxe.d, 6, false, false);
          if (!vyf.b(paramsxe.e, (String)localObject1)) {
            break label964;
          }
          paramsxe.e = ((String)localObject1);
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramsxe.jdField_f_of_type_JavaLangString))
        {
          localObject1 = suj.a(paramsxe.jdField_g_of_type_JavaLangString, paramsxe.d, 6, false, false);
          if (!vyf.b(paramsxe.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramsxe.jdField_f_of_type_JavaLangString = ((String)localObject1);
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramsxe.m))
        {
          localObject1 = suj.a(paramsxe.jdField_g_of_type_JavaLangString, paramsxe.d, 5, false, false);
          if (!vyf.b(paramsxe.m, (String)localObject1)) {
            break label986;
          }
          paramsxe.m = ((String)localObject1);
          ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramsxe.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramsxe.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramsxe.a().getStringExtra("pk_comment_content", null);
            int i = paramsxe.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramsxe.a().getStringExtra("pk_vid", null);
            localObject4 = paramsxe.a().getStringExtra("post_pk_comment_style", null);
            sze.a((String)localObject1, (String)localObject2, i, paramsxe.jdField_g_of_type_JavaLangString, paramsxe.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (tcw)tcz.a(5);
      Object localObject2 = (uvx)tcz.a(11);
      Object localObject4 = ((tcw)localObject3).a(paramsxe.a(), paramsxe.a());
      ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new svv(false);
      boolean bool;
      Object localObject5;
      svu localsvu;
      svt localsvt;
      Object localObject6;
      tnv localtnv;
      if (!paramsxe.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((svv)localObject1).jdField_b_of_type_Boolean = bool;
        ((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramsxe.a();
        localObject4 = paramsxe.a();
        if ((localObject4 == null) || (((teq)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((svv)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((teq)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localsvu = new svu();
        localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = uvx.a((String)localObject5, paramsxe.a().mLocalDate);
        localsvu.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localsvt = new svt();
        localsvt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramsxe.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramsxe.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localtnv = (tnv)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localtnv.jdField_a_of_type_JavaLangString)) {
              if ((!(localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localtnv.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((uvx)localObject2).a(localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localtnv.jdField_a_of_type_JavaUtilMap.get(paramsxe.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        vxp.a(((StoryVideoItem)localObject5).mVid);
        localsvt.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)localObject3).a((StoryVideoItem)localObject5);
        ((uvx)localObject2).a(localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((uvx)localObject2).a(localtnv.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localsvu.jdField_a_of_type_JavaUtilArrayList.add(localsvt);
        ((svv)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localsvu);
        break label603;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localsvu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localtnv.jdField_b_of_type_JavaLangString;
        vxp.a(localtnv.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramsxe.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramsxe.jdField_a_of_type_Long;
        vei.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { vei.b(paramsxe.jdField_f_of_type_Int) + "", paramsxe.jdField_b_of_type_Long + "", "", paramsxe.jdField_g_of_type_Int + "" });
        if (bjjc.c)
        {
          l1 = bjjc.h.a[0] + l2;
          long l3 = bjjc.h.a[1];
          bjjc.h.a(2, l2 - l3);
          if (bjjc.h.a())
          {
            l2 = bjjc.h.a[0];
            l3 = bjjc.h.a[1];
            long l4 = bjjc.h.a[2];
            if ((vei.a(l1, 0L, 120000L)) && (vei.a(l2, 0L, 120000L)) && (vei.a(l3, 0L, 120000L)) && (vei.a(l4, 0L, 120000L))) {
              vei.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            bjjc.h.c();
          }
        }
      }
      if ((paramsxe.jdField_a_of_type_Int == 5) || (paramsxe.jdField_a_of_type_Int == 3) || (paramsxe.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        vei.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramsxe.jdField_a_of_type_Long), new String[] { vei.b(paramsxe.jdField_f_of_type_Int) + "", paramsxe.jdField_b_of_type_Long + "", "", paramsxe.jdField_g_of_type_Int + "" });
      }
      if (((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((svv)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramsxe.a();
        ((svv)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramsxe.jdField_g_of_type_JavaLangString;
        ((svv)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)localObject3).a(paramsxe.jdField_g_of_type_JavaLangString, ((svv)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((svv)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((svv)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((uvx)localObject2).a(((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramsxe.jdField_b_of_type_Int > 0) {
          vei.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramsxe.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramsxe.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramsxe.jdField_a_of_type_Long;
        vei.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), vei.a(BaseApplication.getContext()), String.valueOf(paramsxe.jdField_b_of_type_Int) });
        vei.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), vei.a(BaseApplication.getContext()), String.valueOf(paramsxe.jdField_b_of_type_Int) });
        localObject2 = paramsxe.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        vei.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramsxe.h });
        vee.a(2444494, null);
        ved.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramsxe.a(), Long.valueOf(l1));
        swc.a(paramsxe.a());
      }
      if (((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        stb.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        vei.a("mystory", "publish_fail", 0, 0, new String[] { vei.b(paramsxe.jdField_f_of_type_Int) + "", paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramsxe.jdField_b_of_type_Int > 0) {
          vei.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramsxe.jdField_a_of_type_Long;
        localObject1 = String.format(paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramsxe.jdField_b_of_type_Int), Integer.valueOf(paramsxe.jdField_c_of_type_Int), paramsxe.a(), paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        vei.b("publish_story", "publish_all_old", 0, paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), vei.a(BaseApplication.getContext()), String.valueOf(paramsxe.jdField_b_of_type_Int) });
        if (!"composite".equals(paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          vei.b("publish_story", "publish_all", 0, paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), vei.a(BaseApplication.getContext()), String.valueOf(paramsxe.jdField_b_of_type_Int) });
        }
        localObject2 = paramsxe.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        vei.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramsxe.h });
        vee.a(2444493, paramsxe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        ved.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramsxe.a(), Long.valueOf(l1));
        return;
      }
    } while (((svv)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    stb.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(sxe paramsxe, ErrorMessage paramErrorMessage)
  {
    if (paramsxe.jdField_a_of_type_Int == 5) {
      svx.a().a(paramsxe.a(), paramsxe.jdField_g_of_type_JavaLangString);
    }
    while ((paramsxe.jdField_a_of_type_Int != 6) && (paramsxe.jdField_a_of_type_Int != 3) && (paramsxe.jdField_a_of_type_Int != 7)) {
      return;
    }
    svx.a().d(paramsxe.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	svl:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 742	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lsxc;
    //   16: checkcast 154	sxe
    //   19: invokevirtual 186	sxe:a	()Ljava/lang/String;
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
    //   37: getfield 734	svl:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 451	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 84 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 88 1 0
    //   60: checkcast 154	sxe
    //   63: invokevirtual 186	sxe:a	()Ljava/lang/String;
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
    //   0	89	0	this	svl
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
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Svw);
  }
  
  public void c(String paramString)
  {
    Object localObject = (tcw)tcz.a(5);
    StoryVideoItem localStoryVideoItem = ((tcw)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        vyf.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        vyf.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        vyf.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((tcw)localObject).a(paramString);
    localObject = new sxe(paramString);
    super.c((sxc)localObject);
    ved.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    swc.a(((sxe)localObject).a());
    Bosses.get().scheduleJobDelayed(new svq(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */