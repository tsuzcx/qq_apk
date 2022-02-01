package dov.com.qq.im.ae.download;

import bcxw;
import bord;
import borf;
import borg;
import bpam;
import java.util.List;
import java.util.Map;

public class AEResManager$4
  implements Runnable
{
  public AEResManager$4(borg paramborg, borf paramborf, List paramList, bcxw parambcxw) {}
  
  public void run()
  {
    bpam.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_Borf);
    borg.a(this.this$0).put(this.jdField_a_of_type_Borf, Integer.valueOf(3));
    borg.b(this.this$0).put(this.jdField_a_of_type_Borf, Long.valueOf(System.currentTimeMillis()));
    bord.a(this.jdField_a_of_type_Borf, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bcxw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */