package dov.com.tencent.mobileqq.activity.shortvideo;

import aoip;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EncodeVideoTask$VideoSaveAlumCallBack
  implements FFmpegExecuteResponseCallback
{
  long jdField_a_of_type_Long;
  aoip jdField_a_of_type_Aoip;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public EncodeVideoTask$VideoSaveAlumCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, aoip paramaoip)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_Aoip = paramaoip;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File(this.b));
    com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_JavaLangString);
    EncodeVideoTask.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 3);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D + ", isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Aoip.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Aoip.a(-12);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step fail:" + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */