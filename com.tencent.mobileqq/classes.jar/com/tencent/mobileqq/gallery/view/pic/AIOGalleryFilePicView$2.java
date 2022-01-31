package com.tencent.mobileqq.gallery.view.pic;

import android.app.Activity;
import android.util.Pair;
import android.util.SparseArray;
import apur;
import awqx;
import bahv;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import vup;

public class AIOGalleryFilePicView$2
  implements Runnable
{
  public AIOGalleryFilePicView$2(apur paramapur, int paramInt, SparseArray paramSparseArray, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidAppActivity == null) || (this.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    Object localObject;
    String str1;
    String str2;
    if (vup.a(this.jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (!(localObject instanceof Pair)) {
        break label306;
      }
      localObject = (Pair)localObject;
      str1 = String.valueOf(((Pair)localObject).second).trim();
      str2 = String.valueOf(((Pair)localObject).first).trim();
    }
    label278:
    label285:
    label306:
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localObject = null;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("scannerType", str1);
            ((JSONObject)localObject).put("scannerResult", str2);
            if (localObject == null)
            {
              localObject = "";
              this.this$0.a(2131627276, 2130839598, 55, (String)localObject, this.jdField_a_of_type_JavaUtilArrayList);
              awqx.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
              if (vup.b(this.jdField_a_of_type_Int))
              {
                localObject = this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
                if (!(localObject instanceof String)) {
                  continue;
                }
                str1 = (String)localObject;
              }
            }
          }
          catch (JSONException localJSONException4)
          {
            continue;
            localObject = null;
            continue;
          }
          try
          {
            localObject = new JSONObject();
          }
          catch (JSONException localJSONException2)
          {
            localObject = null;
            localJSONException2.printStackTrace();
            continue;
            localObject = ((JSONObject)localObject).toString();
          }
        }
        try
        {
          ((JSONObject)localObject).put("strMini", str1);
          if (localObject != null) {
            break label285;
          }
          localObject = "";
          this.this$0.a(2131627275, 2130839597, 56, (String)localObject, this.jdField_a_of_type_JavaUtilArrayList);
          awqx.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
          this.this$0.jdField_a_of_type_Bahv.c();
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label278;
        }
        localJSONException1 = localJSONException1;
        localObject = null;
        localJSONException1.printStackTrace();
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.pic.AIOGalleryFilePicView.2
 * JD-Core Version:    0.7.0.1
 */