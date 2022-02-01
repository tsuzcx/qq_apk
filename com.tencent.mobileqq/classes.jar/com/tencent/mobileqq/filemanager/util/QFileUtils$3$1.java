package com.tencent.mobileqq.filemanager.util;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class QFileUtils$3$1
  implements Runnable
{
  QFileUtils$3$1(QFileUtils.3 param3, int paramInt, SparseArray paramSparseArray) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = QRUtils.a(this.jdField_a_of_type_Int);
    String str2 = "";
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if ((localObject1 instanceof Pair))
      {
        localObject1 = (Pair)localObject1;
        String str1 = String.valueOf(((Pair)localObject1).second).trim();
        String str3 = String.valueOf(((Pair)localObject1).first).trim();
        try
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("scannerType", str1);
            ((JSONObject)localObject1).put("scannerResult", str3);
          }
          catch (JSONException localJSONException1) {}
          localJSONException2.printStackTrace();
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((JSONObject)localObject1).toString();
      }
      localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(55);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = ((String)localObject1);
      localArrayList.add(localObject2);
    }
    if (QRUtils.b(this.jdField_a_of_type_Int))
    {
      localObject2 = this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
      localObject1 = localObject4;
      if ((localObject2 instanceof String))
      {
        localObject2 = (String)localObject2;
        try
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("strMini", localObject2);
          }
          catch (JSONException localJSONException3) {}
          localJSONException4.printStackTrace();
        }
        catch (JSONException localJSONException4)
        {
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null) {
        localObject1 = str2;
      } else {
        localObject1 = ((JSONObject)localObject1).toString();
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(56);
      localActionSheetItem.argus = ((String)localObject1);
      localArrayList.add(localActionSheetItem);
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIQRMenuItemController != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIQRMenuItemController.a(this.this$0.jdField_a_of_type_JavaLangString, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.3.1
 * JD-Core Version:    0.7.0.1
 */