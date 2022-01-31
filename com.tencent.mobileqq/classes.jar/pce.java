import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.Task;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import mqq.app.AppRuntime;

public class pce
  extends VideoCombineHelper.Task
{
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public pce(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    super(paramVideoCombineHelper, paramTaskListener, paramString);
    paramVideoCombineHelper = a();
    int i = 0;
    while (i < paramVideoCombineHelper.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramTaskListener = (String)paramVideoCombineHelper.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramTaskListener, ".mp4");
      paramVideoCombineHelper.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramTaskListener)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramTaskListener);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramTaskListener, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramVideoCombineHelper.jdField_b_of_type_JavaLangString))
    {
      paramTaskListener = new File(a(paramVideoCombineHelper.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramTaskListener.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoCombineHelper.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCombineHelper.jdField_b_of_type_JavaLangString, new File(paramTaskListener.getAbsolutePath()));
      }
      paramVideoCombineHelper.d = paramTaskListener.getAbsolutePath();
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = UUID.nameUUIDFromBytes(paramString1.getBytes());
    paramString1 = b().getAbsolutePath() + File.separator + "v_" + paramString1.toString() + paramString2;
    paramString2 = new File(paramString1);
    if (!paramString2.getParentFile().exists()) {
      paramString2.mkdirs();
    }
    return paramString1;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new Bundle();
    VideoCombineHelper.CombineParams localCombineParams = a();
    if (localCombineParams.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new DownloadTask(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((DownloadTask)localObject2).b = 3;
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a().a((DownloadTask)localObject2, new pcf(this, localCombineParams, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localCombineParams.jdField_b_of_type_JavaUtilArrayList.iterator();
        int i = 1;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          File localFile = new File(a() + File.separator + "v_" + i + ".mp4");
          localArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            FileUtils.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this);
        localCombineParams.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new pbw(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.c, localCombineParams.jdField_b_of_type_JavaUtilArrayList, localCombineParams.d, localCombineParams.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localCombineParams.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task.d = "lib not ready";
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pce
 * JD-Core Version:    0.7.0.1
 */