import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

class mec
  implements Runnable
{
  mec(meb parammeb, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equals(VideoPreDownloadMgr.a(this.jdField_a_of_type_Meb.a)))
    {
      if (this.jdField_a_of_type_Meb.a.a(this.b, this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.a(), 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + this.jdField_a_of_type_JavaLangString);
        }
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Meb.a, null);
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Meb.a);
      }
    }
    else {
      return;
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_Meb.a, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mec
 * JD-Core Version:    0.7.0.1
 */