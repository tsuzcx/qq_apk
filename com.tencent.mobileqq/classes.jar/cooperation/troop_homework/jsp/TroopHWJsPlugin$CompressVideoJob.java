package cooperation.troop_homework.jsp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import bifw;
import bmjd;
import bmjp;
import bmjq;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class TroopHWJsPlugin$CompressVideoJob
  implements Runnable
{
  private bmjp jdField_a_of_type_Bmjp;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public TroopHWJsPlugin$CompressVideoJob(bmjp parambmjp, HashMap<Integer, String> paramHashMap)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
    this.jdField_a_of_type_Bmjp = paramHashMap;
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
          str = VFSAssistantUtils.getSDKPrivatePath(localVFSFile.getAbsolutePath() + "/" + new File((String)localObject).getName());
          this.this$0.a(i, 0.05F);
          j = bmjd.a(localContext, (String)localObject, str);
          this.this$0.a(i, 0.1F);
          if (j != 1) {
            break label306;
          }
          localObject = this.this$0.a(this.this$0, i, (String)localObject, localBitmap, this.jdField_a_of_type_Bmjp, 2);
          this.this$0.b.put(Integer.valueOf(i), localObject);
          ((bmjq)localObject).a();
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressVideo, Exception happened!", localException);
          TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(0);
        }
        continue;
        label306:
        bmjq localbmjq;
        if ((j == 0) && (new File(str).exists()))
        {
          localbmjq = this.this$0.a(this.this$0, i, str, localBitmap, this.jdField_a_of_type_Bmjp, 2);
          this.this$0.b.put(Integer.valueOf(i), localbmjq);
          localbmjq.a();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHWJsPlugin", 2, "CompressVideoJob failed:" + j);
          }
          localbmjq = this.this$0.a(this.this$0, i, localbmjq, localBitmap, this.jdField_a_of_type_Bmjp, 2);
          this.this$0.b.put(Integer.valueOf(i), localbmjq);
          localbmjq.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.CompressVideoJob
 * JD-Core Version:    0.7.0.1
 */