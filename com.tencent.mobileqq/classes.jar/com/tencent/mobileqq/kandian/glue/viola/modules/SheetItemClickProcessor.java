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
  JSONObject b;
  private WeakReference<Activity> c;
  private boolean d = false;
  private List<ActionItem> e;
  private List<ActionItem> f;
  private SparseArray<SheetItemClickProcessor.ClickAction> g = new SparseArray();
  private BridgeModule h;
  
  public SheetItemClickProcessor(boolean paramBoolean, List<ActionItem> paramList1, List<ActionItem> paramList2, JSONObject paramJSONObject, WeakReference<Activity> paramWeakReference, String paramString, BridgeModule paramBridgeModule)
  {
    this.b = paramJSONObject;
    this.c = paramWeakReference;
    BridgeModule.shareCallBackId = paramString;
    this.d = paramBoolean;
    this.h = paramBridgeModule;
    this.e = paramList1;
    this.f = paramList2;
    a(this.c, this.b);
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject1 = this.h;
      localObject1 = this.h;
      localJSONObject.put("type", BridgeModule.shareCallBackType);
      localObject1 = this.h;
      localObject1 = this.h;
      localJSONObject.put("action", BridgeModule.shareCallBackName);
      localObject1 = this.h;
      localJSONObject.put("fromCallback", 0);
      localObject1 = this.h;
      if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
      {
        localObject1 = this.h;
        localObject2 = this.h;
        ((BridgeModule)localObject1).invokeCallJS(BridgeModule.shareCallBackId, localJSONObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject1 = a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processClick error=");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(WeakReference<Activity> paramWeakReference, JSONObject paramJSONObject)
  {
    this.g.put(1, new SheetItemClickProcessor.CopyLinkAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(5, new SheetItemClickProcessor.QQBrowserAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(4, new SheetItemClickProcessor.SysBrowserAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(6, new SheetItemClickProcessor.FavoriteAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(11, new SheetItemClickProcessor.JuBaoAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(21, new SheetItemClickProcessor.ScreenshotAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(26, new SheetItemClickProcessor.SendComputerAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(35, new SheetItemClickProcessor.AddQQFriendAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(37, new SheetItemClickProcessor.FriendAioAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(31, new SheetItemClickProcessor.ShowMoreInfoAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(39, new SheetItemClickProcessor.SaveImageAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.g.put(-111, new SheetItemClickProcessor.DefaultClickAction(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
  }
  
  private boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = this.h.mShareHelper;
    Object localObject2 = this.e;
    List localList = this.f;
    int i;
    if (paramInt == 72) {
      i = 2;
    } else {
      i = paramInt;
    }
    localObject1 = ((ReadInJoyShareHelperV2)localObject1).a((List)localObject2, localList, i);
    if ((localObject1 != null) && (((ActionItem)localObject1).c))
    {
      localObject1 = new JSONObject();
      if (paramInt == 72)
      {
        localObject2 = this.h;
        BridgeModule.shareCallBackName = "qq_friend";
        ((BridgeModule)localObject2).shareToFriendUin = paramActionSheetItem.uin;
        this.h.shareToFriendUinType = paramActionSheetItem.uinType;
        this.h.shareToFriendUinName = paramActionSheetItem.label;
      }
      else
      {
        this.h.shareToFriendUin = "";
      }
      try
      {
        paramActionSheetItem = this.h;
        paramActionSheetItem = this.h;
        ((JSONObject)localObject1).put("type", BridgeModule.shareCallBackType);
        paramActionSheetItem = this.h;
        paramActionSheetItem = this.h;
        ((JSONObject)localObject1).put("action", BridgeModule.shareCallBackName);
        paramActionSheetItem = this.h;
        ((JSONObject)localObject1).put("fromCallback", 0);
        paramActionSheetItem = this.h;
        if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
        {
          paramActionSheetItem = this.h;
          localObject2 = this.h;
          paramActionSheetItem.invokeCallJS(BridgeModule.shareCallBackId, localObject1);
          return true;
        }
      }
      catch (JSONException paramActionSheetItem)
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processClick webhandle error=");
        ((StringBuilder)localObject2).append(paramActionSheetItem.getMessage());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return true;
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    String str1 = this.b.optString("rowkey", "");
    int i = this.b.optInt("source", -1);
    int j = this.b.optInt("report_from", -1);
    String str2 = this.b.optString("vid", "");
    String str3 = this.b.optString("algorithmId", "");
    String str4 = this.b.optString("articleId", "");
    String str5 = this.b.optString("topicId", "");
    if ((j == 4) || (j == 11)) {
      this.h.reportVideoShareClick(str1, str2, i, a(paramInt), b(paramInt), false, j, str3, str4, str5);
    }
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
    if (this.c.get() == null) {
      return false;
    }
    if (this.b == null) {
      return true;
    }
    BridgeModule.shareCallBackType = this.h.mShareUtils.a(paramInt);
    BridgeModule.shareCallBackName = this.h.mShareHelper.a(paramInt);
    if ((this.d) && (b(paramInt, paramActionSheetItem))) {
      return true;
    }
    String str1 = this.b.optString("share_url");
    String str2 = this.b.optString("aio_share_url");
    String str3 = this.b.optString("puin");
    SheetItemClickProcessor.ClickAction localClickAction = (SheetItemClickProcessor.ClickAction)this.g.get(paramInt);
    if (localClickAction != null) {
      localClickAction.a(str1, str2, str3, paramActionSheetItem, paramInt);
    } else {
      ((SheetItemClickProcessor.ClickAction)this.g.get(-111)).a(str1, str2, str3, paramActionSheetItem, paramInt);
    }
    ReadInJoyShareHelperV2.a(paramInt, true, this.b.optString("rowkey", ""));
    a();
    c(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */