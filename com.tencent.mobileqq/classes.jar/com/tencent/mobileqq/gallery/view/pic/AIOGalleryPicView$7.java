package com.tencent.mobileqq.gallery.view.pic;

import android.app.Activity;
import android.util.Pair;
import android.util.SparseArray;
import aqox;
import axqw;
import bbiw;
import bcuq;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import whm;

public class AIOGalleryPicView$7
  implements Runnable
{
  public AIOGalleryPicView$7(aqox paramaqox, int paramInt, SparseArray paramSparseArray, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidAppActivity == null) || (this.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    Object localObject;
    String str1;
    String str2;
    if (whm.a(this.jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (!(localObject instanceof Pair)) {
        break label296;
      }
      localObject = (Pair)localObject;
      str1 = String.valueOf(((Pair)localObject).second).trim();
      str2 = String.valueOf(((Pair)localObject).first).trim();
    }
    label268:
    label275:
    label296:
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
              bbiw.a(55, this.jdField_a_of_type_JavaUtilArrayList, (String)localObject, 0);
              axqw.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
              if (whm.b(this.jdField_a_of_type_Int))
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
            break label275;
          }
          localObject = "";
          bbiw.a(56, this.jdField_a_of_type_JavaUtilArrayList, (String)localObject, 0);
          axqw.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
          this.this$0.jdField_a_of_type_Bcuq.d();
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label268;
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
 * Qualified Name:     com.tencent.mobileqq.gallery.view.pic.AIOGalleryPicView.7
 * JD-Core Version:    0.7.0.1
 */