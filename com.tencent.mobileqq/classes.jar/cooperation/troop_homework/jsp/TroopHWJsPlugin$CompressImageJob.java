package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.text.TextUtils;
import bkdk;
import bkdl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class TroopHWJsPlugin$CompressImageJob
  implements Runnable
{
  private HashMap<Integer, String> a;
  
  public TroopHWJsPlugin$CompressImageJob(HashMap<Integer, String> paramHashMap)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject.clone());
  }
  
  public void run()
  {
    Object localObject1 = new VFSFile(TroopHWJsPlugin.jdField_a_of_type_JavaLangString);
    if (!((VFSFile)localObject1).exists()) {
      ((VFSFile)localObject1).mkdirs();
    }
    localObject1 = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWJsPlugin", 2, "CompressImage, path = " + (String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        try
        {
          localObject2 = TroopHWJsPlugin.a(i, (String)localObject2, this.this$0.c, this.this$0);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label207;
          }
          QLog.e("TroopHWJsPlugin", 2, "compressImage failed!");
          TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(0);
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressImage failed!", localException);
          TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(0);
        }
        continue;
        label207:
        this.this$0.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localException);
        ((HashMap)localObject1).put(Integer.valueOf(i), localException);
        bkdk localbkdk = new bkdk(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.e, this.this$0.d);
        bkdl localbkdl = this.this$0.a(this.this$0, i, localException, null, localbkdk, 1);
        this.this$0.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localbkdl);
        localbkdl.a();
      }
      else
      {
        TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(3);
        QLog.e("TroopHWJsPlugin", 2, "compressImage failed! empty image!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.CompressImageJob
 * JD-Core Version:    0.7.0.1
 */