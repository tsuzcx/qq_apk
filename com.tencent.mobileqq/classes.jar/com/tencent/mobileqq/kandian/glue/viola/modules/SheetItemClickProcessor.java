package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.kandian.biz.share.ActionItem;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class SheetItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  public static String a = "SheetItemClickProcessor";
  private SparseArray<SheetItemClickProcessor.ClickAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BridgeModule jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ActionItem> jdField_a_of_type_JavaUtilList;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean = false;
  private List<ActionItem> b;
  
  public SheetItemClickProcessor(boolean paramBoolean, List<ActionItem> paramList1, List<ActionItem> paramList2, JSONObject paramJSONObject, WeakReference<Activity> paramWeakReference, String paramString, BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    BridgeModule.shareCallBackId = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule = paramBridgeModule;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    a(this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_OrgJsonJSONObject);
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      localJSONObject.put("type", BridgeModule.shareCallBackType);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      localJSONObject.put("action", BridgeModule.shareCallBackName);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      localJSONObject.put("fromCallback", 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
      if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        ((BridgeModule)localObject1).invokeCallJS(BridgeModule.shareCallBackId, localJSONObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processClick error=");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(int paramInt)
  {
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    int i = this.jdField_a_of_type_OrgJsonJSONObject.optInt("source", -1);
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("report_from", -1);
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("vid", "");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("algorithmId", "");
    String str4 = this.jdField_a_of_type_OrgJsonJSONObject.optString("articleId", "");
    String str5 = this.jdField_a_of_type_OrgJsonJSONObject.optString("topicId", "");
    if ((j == 4) || (j == 11)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.reportVideoShareClick(str1, str2, i, a(paramInt), b(paramInt), false, j, str3, str4, str5);
    }
  }
  
  private void a(WeakReference<Activity> paramWeakReference, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new SheetItemClickProcessor.CopyLinkAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new SheetItemClickProcessor.QQBrowserAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new SheetItemClickProcessor.SysBrowserAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new SheetItemClickProcessor.FavoriteAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new SheetItemClickProcessor.JuBaoAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, new SheetItemClickProcessor.ScreenshotAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new SheetItemClickProcessor.SendComputerAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(35, new SheetItemClickProcessor.AddQQFriendAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(37, new SheetItemClickProcessor.FriendAioAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(31, new SheetItemClickProcessor.ShowMoreInfoAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new SheetItemClickProcessor.SaveImageAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new SheetItemClickProcessor.AddVideoToTopicAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(-111, new SheetItemClickProcessor.DefaultClickAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
  }
  
  private boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.mShareHelper;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    List localList = this.b;
    int i;
    if (paramInt == 72) {
      i = 2;
    } else {
      i = paramInt;
    }
    localObject1 = ((ReadInJoyShareHelperV2)localObject1).a((List)localObject2, localList, i);
    if ((localObject1 != null) && (((ActionItem)localObject1).jdField_a_of_type_Boolean))
    {
      localObject1 = new JSONObject();
      if (paramInt == 72)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        BridgeModule.shareCallBackName = "qq_friend";
        ((BridgeModule)localObject2).shareToFriendUin = paramActionSheetItem.uin;
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.shareToFriendUinType = paramActionSheetItem.uinType;
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.shareToFriendUinName = paramActionSheetItem.label;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.shareToFriendUin = "";
      }
      try
      {
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        ((JSONObject)localObject1).put("type", BridgeModule.shareCallBackType);
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        ((JSONObject)localObject1).put("action", BridgeModule.shareCallBackName);
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        ((JSONObject)localObject1).put("fromCallback", 0);
        paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
        if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
        {
          paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
          paramActionSheetItem.invokeCallJS(BridgeModule.shareCallBackId, localObject1);
          return true;
        }
      }
      catch (JSONException paramActionSheetItem)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processClick webhandle error=");
        ((StringBuilder)localObject2).append(paramActionSheetItem.getMessage());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return true;
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    int i = 5;
    if (paramInt != 2) {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 9)
            {
              if (paramInt != 10)
              {
                if (paramInt == 12) {
                  return i;
                }
                if (paramInt != 13)
                {
                  if ((paramInt != 72) && (paramInt != 73)) {
                    return -1;
                  }
                }
                else {
                  return 0;
                }
              }
              else
              {
                return 4;
              }
            }
            else {
              return 3;
            }
          }
          else {
            return 6;
          }
        }
        else {
          return 7;
        }
      }
      else {
        return 2;
      }
    }
    i = 1;
    return i;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return false;
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      return true;
    }
    BridgeModule.shareCallBackType = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.mShareUtils.a(paramInt);
    BridgeModule.shareCallBackName = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.mShareHelper.a(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (b(paramInt, paramActionSheetItem))) {
      return true;
    }
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url");
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("aio_share_url");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("puin");
    SheetItemClickProcessor.ClickAction localClickAction = (SheetItemClickProcessor.ClickAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localClickAction != null) {
      localClickAction.a(str1, str2, str3, paramActionSheetItem, paramInt);
    } else {
      ((SheetItemClickProcessor.ClickAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(-111)).a(str1, str2, str3, paramActionSheetItem, paramInt);
    }
    a();
    a(paramInt);
    return super.a(paramInt, paramActionSheetItem);
  }
  
  public int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 6)
      {
        if (paramInt != 11)
        {
          if (paramInt != 26)
          {
            if (paramInt != 44)
            {
              if (paramInt != 72) {
                return -1;
              }
              return 19;
            }
            return 7;
          }
          return 2;
        }
        return 5;
      }
      return 4;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */