package cooperation.troop_homework.jsp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import bdzf;
import begz;
import bkcy;
import bkdk;
import bkdl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class TroopHWJsPlugin$CompressVideoJob
  implements Runnable
{
  private bkdk jdField_a_of_type_Bkdk;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public TroopHWJsPlugin$CompressVideoJob(bkdk parambkdk, HashMap<Integer, String> paramHashMap)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
    this.jdField_a_of_type_Bkdk = paramHashMap;
  }
  
  public void run()
  {
    Context localContext = this.this$0.mRuntime.a().getApplicationContext();
    VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.a);
    if (!localVFSFile.exists()) {
      localVFSFile.mkdirs();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWJsPlugin", 2, "compressVideo, path = " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Bitmap localBitmap;
        String str;
        int j;
        try
        {
          localBitmap = TroopHWJsPlugin.a(this.this$0, i, (String)localObject);
          str = bdzf.a(localVFSFile.getAbsolutePath() + "/" + new File((String)localObject).getName());
          this.this$0.a(i, 0.05F);
          j = bkcy.a(localContext, (String)localObject, str);
          this.this$0.a(i, 0.1F);
          if (j != 1) {
            break label306;
          }
          localObject = this.this$0.a(this.this$0, i, (String)localObject, localBitmap, this.jdField_a_of_type_Bkdk, 2);
          this.this$0.b.put(Integer.valueOf(i), localObject);
          ((bkdl)localObject).a();
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressVideo, Exception happened!", localException);
          TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(0);
        }
        continue;
        label306:
        bkdl localbkdl;
        if ((j == 0) && (new File(str).exists()))
        {
          localbkdl = this.this$0.a(this.this$0, i, str, localBitmap, this.jdField_a_of_type_Bkdk, 2);
          this.this$0.b.put(Integer.valueOf(i), localbkdl);
          localbkdl.a();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHWJsPlugin", 2, "CompressVideoJob failed:" + j);
          }
          localbkdl = this.this$0.a(this.this$0, i, localbkdl, localBitmap, this.jdField_a_of_type_Bkdk, 2);
          this.this$0.b.put(Integer.valueOf(i), localbkdl);
          localbkdl.a();
        }
      }
      else
      {
        TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(4);
        QLog.e("TroopHWJsPlugin", 2, "compressVideo,video empty!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.CompressVideoJob
 * JD-Core Version:    0.7.0.1
 */