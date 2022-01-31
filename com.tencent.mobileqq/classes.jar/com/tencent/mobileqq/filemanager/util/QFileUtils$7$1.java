package com.tencent.mobileqq.filemanager.util;

import android.util.Pair;
import android.util.SparseArray;
import areh;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import xwb;

class QFileUtils$7$1
  implements Runnable
{
  QFileUtils$7$1(QFileUtils.7 param7, int paramInt, SparseArray paramSparseArray) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    String str;
    if (xwb.a(this.jdField_a_of_type_Int))
    {
      localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (!(localObject1 instanceof Pair)) {
        break label285;
      }
      localObject1 = (Pair)localObject1;
      localObject2 = String.valueOf(((Pair)localObject1).second).trim();
      str = String.valueOf(((Pair)localObject1).first).trim();
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject1).put("scannerType", localObject2);
            ((JSONObject)localObject1).put("scannerResult", str);
            if (localObject1 == null)
            {
              localObject1 = "";
              localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(55);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = ((String)localObject1);
              localArrayList.add(localObject2);
              if (xwb.b(this.jdField_a_of_type_Int))
              {
                localObject2 = this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
                localObject1 = localObject4;
                if ((localObject2 instanceof String)) {
                  localObject2 = (String)localObject2;
                }
              }
            }
          }
          catch (JSONException localJSONException4)
          {
            continue;
          }
          try
          {
            localObject1 = new JSONObject();
          }
          catch (JSONException localJSONException2)
          {
            localObject1 = localObject3;
            localJSONException2.printStackTrace();
            continue;
            localObject1 = ((JSONObject)localObject1).toString();
            continue;
          }
          try
          {
            ((JSONObject)localObject1).put("strMini", localObject2);
            if (localObject1 != null) {
              continue;
            }
            localObject1 = "";
            localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(56);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = ((String)localObject1);
            localArrayList.add(localObject2);
            if ((localArrayList == null) || (this.this$0.jdField_a_of_type_Areh == null)) {
              break;
            }
            this.this$0.jdField_a_of_type_Areh.a(this.this$0.jdField_a_of_type_JavaLangString, localArrayList);
            return;
          }
          catch (JSONException localJSONException3) {}
        }
        localJSONException1 = localJSONException1;
        localObject1 = null;
      }
      localJSONException1.printStackTrace();
      continue;
      localObject1 = ((JSONObject)localObject1).toString();
      continue;
      label285:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.7.1
 * JD-Core Version:    0.7.0.1
 */