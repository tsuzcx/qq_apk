import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.1;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sjw
{
  public static String a;
  private int jdField_a_of_type_Int;
  private ArrayList<vno> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<sjy> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  }
  
  public sjw()
  {
    b();
  }
  
  private String a()
  {
    return sfm.r;
  }
  
  private void a(sjy paramsjy)
  {
    urk.c(jdField_a_of_type_JavaLangString, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramsjy.jdField_b_of_type_JavaLangString))
    {
      urk.e(jdField_a_of_type_JavaLangString, "generate failed. the video local path is null.");
      return;
    }
    if (vlm.c(paramsjy.e))
    {
      urk.b(jdField_a_of_type_JavaLangString, "the video has existed in the album.");
      return;
    }
    sjx localsjx = new sjx(this, paramsjy);
    Object localObject2 = vnb.a(paramsjy.jdField_b_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramsjy.jdField_a_of_type_Int;
      localObject1[2] = paramsjy.jdField_b_of_type_Int;
    }
    int j = localObject1[0];
    paramsjy.jdField_a_of_type_Int = localObject1[1];
    paramsjy.jdField_b_of_type_Int = localObject1[2];
    int i;
    String str1;
    String str2;
    if (paramsjy.jdField_a_of_type_Boolean)
    {
      i = 2;
      str1 = vnr.a(BaseApplication.getContext(), paramsjy.jdField_a_of_type_JavaLangString, paramsjy.jdField_a_of_type_Int, paramsjy.jdField_b_of_type_Int, i);
      if (TextUtils.isEmpty(str1)) {
        urk.e(jdField_a_of_type_JavaLangString, "Client Error: generate water mark failed! May be this task is strange! %s", new Object[] { paramsjy });
      }
      localObject2 = paramsjy.c;
      localObject1 = vnr.a(paramsjy.jdField_a_of_type_Srq, paramsjy.jdField_a_of_type_Int, paramsjy.jdField_b_of_type_Int);
      str2 = vnr.a(paramsjy.jdField_a_of_type_Srp, paramsjy.jdField_a_of_type_Int, paramsjy.jdField_b_of_type_Int);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label306;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str2 = sfm.u;
        str2 = str2 + paramsjy.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + "_new_mask.png";
        if (!vnr.a((String)localObject2, (String)localObject1, str2))
        {
          urk.e(jdField_a_of_type_JavaLangString, "combineTwoImg mask and vote failed");
          return;
          i = 1;
          break;
          label306:
          localObject1 = str2;
          continue;
        }
        localObject1 = str2;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {
          break label585;
        }
        urk.b(jdField_a_of_type_JavaLangString, "have doodle image, should combine doodle image and logo image.");
        str2 = sfm.k + paramsjy.jdField_a_of_type_JavaLangString + "_newDownloadMask.mp4";
        localObject2 = localObject1;
        if (vnr.a((String)localObject1, str1, str2)) {
          localObject2 = str2;
        }
      }
    }
    for (;;)
    {
      paramsjy.c = ((String)localObject2);
      localObject1 = sfm.k + "hflip" + paramsjy.jdField_a_of_type_JavaLangString + ".mp4";
      if ((j != 0) && (j != -1) && (!vlm.c((String)localObject1)))
      {
        localObject2 = new vno();
        ((vno)localObject2).jdField_a_of_type_Int = 10;
        ((vno)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.1(this, paramsjy, (String)localObject1);
        ((vno)localObject2).jdField_a_of_type_Vnq = new voa(null);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        urk.c(jdField_a_of_type_JavaLangString, "add a hflip command to command list.");
      }
      localObject2 = new vno();
      ((vno)localObject2).jdField_a_of_type_Int = 1;
      ((vno)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.2(this, paramsjy, j, (String)localObject1);
      ((vno)localObject2).jdField_a_of_type_Vnq = localsjx;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      urk.c(jdField_a_of_type_JavaLangString, "add a watermask command to command list.");
      return;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      break;
      label585:
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1;
      }
    }
  }
  
  private String b()
  {
    return sfm.t;
  }
  
  private void b()
  {
    vlm.a(a(), false);
    vlm.a(c(), false);
    vlm.a(b(), false);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private String c()
  {
    return sfm.s;
  }
  
  public String a(@NonNull String paramString)
  {
    return a() + paramString + ".mp4";
  }
  
  public void a()
  {
    urk.c(jdField_a_of_type_JavaLangString, "trigger to execute all tasks in the task list.");
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      urk.e(jdField_a_of_type_JavaLangString, "no task need to be execute.");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((sjy)((Iterator)localObject).next());
    }
    localObject = vni.a(BaseApplication.getContext(), true);
    String str = ((sjy)this.jdField_a_of_type_JavaUtilList.get(0)).e;
    if (((vni)localObject).a())
    {
      if (((vni)localObject).a(str))
      {
        urk.d(jdField_a_of_type_JavaLangString, "this task is already running.");
        return;
      }
      urk.e(jdField_a_of_type_JavaLangString, "a download task is running. let's return.");
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    try
    {
      ((vni)localObject).a(str);
      ((vni)localObject).a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      urk.e(jdField_a_of_type_JavaLangString, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, srq paramsrq, srp paramsrp)
  {
    paramString1 = new sjy(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.jdField_a_of_type_Srq = paramsrq;
    paramString1.jdField_a_of_type_Srp = paramsrp;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = sjj.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      if ((localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        urk.a(jdField_a_of_type_JavaLangString, "waiting other fragments composited. group id is %s.", paramString);
        return false;
      }
    }
    urk.a(jdField_a_of_type_JavaLangString, "all fragments are composited. group id is %s.", paramString);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    urk.b(jdField_a_of_type_JavaLangString, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      urk.e(jdField_a_of_type_JavaLangString, "fromPath or toPath is null.");
      return false;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      urk.e(jdField_a_of_type_JavaLangString, "src file is not exist.");
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      paramString2 = vlm.a(paramString2);
      bool1 = bool2;
      long l = SystemClock.elapsedRealtime();
      bool1 = bool2;
      bool2 = vlm.a(paramString1, paramString2);
      bool1 = bool2;
      urk.b(jdField_a_of_type_JavaLangString, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
      return bool2;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    paramString = sjj.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (paramString == null) {
      return false;
    }
    paramString = paramString.iterator();
    int i = 0;
    label48:
    if (paramString.hasNext())
    {
      if (((PublishVideoEntry)paramString.next()).videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) {
        break label102;
      }
      i += 1;
    }
    label102:
    for (;;)
    {
      break label48;
      urk.a(jdField_a_of_type_JavaLangString, "composite failed count is %d.", Integer.valueOf(i));
      if (i != 1) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */