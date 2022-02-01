package dov.com.qq.im.ae.download;

import bcya;
import bnkr;
import bnkt;
import bnku;
import bnrh;
import java.util.List;
import java.util.Map;

public class AEResManager$4
  implements Runnable
{
  public AEResManager$4(bnku parambnku, bnkt parambnkt, List paramList, bcya parambcya) {}
  
  public void run()
  {
    bnrh.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_Bnkt);
    bnku.a(this.this$0).put(this.jdField_a_of_type_Bnkt, Integer.valueOf(3));
    bnku.b(this.this$0).put(this.jdField_a_of_type_Bnkt, Long.valueOf(System.currentTimeMillis()));
    bnkr.a(this.jdField_a_of_type_Bnkt, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bcya);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */