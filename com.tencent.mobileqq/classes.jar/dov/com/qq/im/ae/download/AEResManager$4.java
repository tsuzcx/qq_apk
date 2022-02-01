package dov.com.qq.im.ae.download;

import bbrg;
import blvl;
import blvn;
import bmbx;
import java.util.List;
import java.util.Map;

public class AEResManager$4
  implements Runnable
{
  public AEResManager$4(blvn paramblvn, AEResInfo paramAEResInfo, List paramList, bbrg parambbrg) {}
  
  public void run()
  {
    bmbx.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo);
    blvn.a(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(3));
    blvn.b(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Long.valueOf(System.currentTimeMillis()));
    blvl.a(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bbrg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */