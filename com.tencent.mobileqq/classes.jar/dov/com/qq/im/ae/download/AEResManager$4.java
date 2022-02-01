package dov.com.qq.im.ae.download;

import bcfe;
import bnpr;
import bnpt;
import bnpu;
import bnzb;
import java.util.List;
import java.util.Map;

public class AEResManager$4
  implements Runnable
{
  public AEResManager$4(bnpu parambnpu, bnpt parambnpt, List paramList, bcfe parambcfe) {}
  
  public void run()
  {
    bnzb.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_Bnpt);
    bnpu.a(this.this$0).put(this.jdField_a_of_type_Bnpt, Integer.valueOf(3));
    bnpu.b(this.this$0).put(this.jdField_a_of_type_Bnpt, Long.valueOf(System.currentTimeMillis()));
    bnpr.a(this.jdField_a_of_type_Bnpt, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bcfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */