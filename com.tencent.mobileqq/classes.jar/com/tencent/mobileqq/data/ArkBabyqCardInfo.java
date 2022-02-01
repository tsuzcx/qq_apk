package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.ark.ArkRecommendController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkBabyqCardInfo
  implements ArkAdapterItemInterface
{
  public final String TAG = "ArkBabyqCardInfo";
  public String appDesc;
  public String appIntent;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String compatibleText;
  public String config;
  public String extra;
  public ArkAioContainerWrapper mArkBabyqContainer;
  public WeakReference<MessageForArkBabyqReply> mBabyQReplyMsg;
  public LinkedList<ArkBabyqCardInfo> mExtendedArkBabyqCardList;
  public String metaList;
  public String promptText;
  
  public ArkBabyqCardInfo(MessageForArkBabyqReply paramMessageForArkBabyqReply)
  {
    reset();
    this.mBabyQReplyMsg = new WeakReference(paramMessageForArkBabyqReply);
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844893);
    if (this.mArkBabyqContainer == null)
    {
      this.mArkBabyqContainer = new ArkAioContainerWrapper();
      this.mArkBabyqContainer.a(paramArkHorizontalListViewAdapter);
    }
    Object localObject = new ArkBabyqCardInfo.Config();
    ((ArkBabyqCardInfo.Config)localObject).fromString(this.config);
    if (((ArkBabyqCardInfo.Config)localObject).autoSize != null) {
      ((ArkBabyqCardInfo.Config)localObject).autoSize.intValue();
    }
    localObject = this.mArkBabyqContainer;
    ((ArkAioContainerWrapper)localObject).a(this.appName, this.appView, this.appMinVersion, this.metaList, paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, this, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((ArkAioContainerWrapper)localObject).setFixSize(BaseChatItemLayout.e, BaseChatItemLayout.e);
    ((ArkAioContainerWrapper)localObject).setMaxSize(BaseChatItemLayout.e, BaseChatItemLayout.e);
    ((ArkAioContainerWrapper)localObject).setMinSize(BaseChatItemLayout.e * 7 / 10, BaseChatItemLayout.e);
    localObject = new ArkBabyqCardInfo.1(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, (ArkAioContainerWrapper)localObject, paramInt);
    ArkAppView localArkAppView1 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView2 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView1.setClipRadius(15.0F);
    localArkAppView1.setBorderType(1);
    localArkAppView2.a(this.mArkBabyqContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
    localArkAppView1.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    localArkAppView1.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    localArkAppView1.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    }
    paramItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkAppItemBubbleBuilder.Holder paramHolder, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    doOnEvent(2);
  }
  
  public void doOnEvent(int paramInt)
  {
    Object localObject = this.mExtendedArkBabyqCardList;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if (localArkBabyqCardInfo != null) {
          localArkBabyqCardInfo.doOnEvent(paramInt);
        }
      }
    }
    localObject = this.mArkBabyqContainer;
    if (localObject != null)
    {
      ((ArkAioContainerWrapper)localObject).doOnEvent(paramInt);
      if (paramInt == 2) {
        this.mArkBabyqContainer = null;
      }
    }
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    ArkAioContainerWrapper localArkAioContainerWrapper = this.mArkBabyqContainer;
    Object localObject = null;
    if (localArkAioContainerWrapper == paramArkAppContainer)
    {
      localObject = this.mBabyQReplyMsg;
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        localObject = (MessageForArkBabyqReply)this.mBabyQReplyMsg.get();
      } else {
        localObject = null;
      }
      paramArkAppContainer = paramArkAppContainer.getAppName();
      if ((localObject != null) && ((((MessageForArkBabyqReply)localObject).getArkBabyqCardCount() >= ArkRecommendController.f) || ((!((MessageForArkBabyqReply)localObject).isSingleApp) && (((MessageForArkBabyqReply)localObject).getArkBabyqCardCountForApp(paramArkAppContainer) >= ArkRecommendController.g)))) {
        return null;
      }
      localObject = new ArkBabyqCardInfo((MessageForArkBabyqReply)localObject);
      ((ArkBabyqCardInfo)localObject).appName = paramArkAppContainer;
      ((ArkBabyqCardInfo)localObject).appView = paramString1;
      ((ArkBabyqCardInfo)localObject).appMinVersion = this.appMinVersion;
      ((ArkBabyqCardInfo)localObject).metaList = paramString2;
      ((ArkBabyqCardInfo)localObject).config = this.config;
      ((ArkBabyqCardInfo)localObject).extra = this.extra;
      if (this.mExtendedArkBabyqCardList == null) {
        this.mExtendedArkBabyqCardList = new LinkedList();
      }
      this.mExtendedArkBabyqCardList.add(0, localObject);
    }
    return localObject;
  }
  
  public boolean fromAppXml(String paramString)
  {
    reset();
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.appName = paramString.optString("name");
        this.appIntent = paramString.optString("intent");
        this.appView = paramString.optString("view");
        this.appDesc = paramString.optString("desc");
        this.appMinVersion = paramString.optString("ver");
        this.promptText = paramString.optString("prompt");
        this.metaList = paramString.optString("meta");
        this.config = paramString.optString("config");
        this.extra = paramString.optString("extra");
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathFromLocal(this.appName);
    arrayOfString[2] = this.appView;
    return arrayOfString;
  }
  
  public int getArkBabyqCardCount()
  {
    Object localObject = this.mExtendedArkBabyqCardList;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if (localArkBabyqCardInfo != null) {
          i += localArkBabyqCardInfo.getArkBabyqCardCount();
        }
      }
    }
    return j + 1;
  }
  
  public int getArkBabyqCardCountForApp(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    int j = 0;
    if (bool) {
      return 0;
    }
    Object localObject = this.mExtendedArkBabyqCardList;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if ((localArkBabyqCardInfo != null) && (paramString.equals(localArkBabyqCardInfo.appName))) {
          j += localArkBabyqCardInfo.getArkBabyqCardCount();
        }
      }
    }
    j = i;
    if (paramString.equals(this.appName)) {
      j = i + 1;
    }
    return j;
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appIntent = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.metaList = null;
    this.config = null;
    this.compatibleText = null;
    this.extra = null;
  }
  
  public String toAppXml()
  {
    try
    {
      Object localObject = new JSONObject();
      if (this.appName != null) {
        ((JSONObject)localObject).put("name", this.appName);
      }
      if (this.appIntent != null) {
        ((JSONObject)localObject).put("intent", this.appIntent);
      }
      if (this.appDesc != null) {
        ((JSONObject)localObject).put("desc", this.appDesc);
      }
      if (this.appView != null) {
        ((JSONObject)localObject).put("view", this.appView);
      }
      if (this.appMinVersion != null) {
        ((JSONObject)localObject).put("ver", this.appMinVersion);
      }
      if (this.promptText != null) {
        ((JSONObject)localObject).put("prompt", this.promptText);
      }
      if (this.extra != null) {
        ((JSONObject)localObject).put("extra", this.extra);
      }
      String str1 = this.metaList;
      StringBuilder localStringBuilder;
      if (str1 != null) {
        try
        {
          ((JSONObject)localObject).put("meta", new JSONObject(this.metaList));
        }
        catch (Exception localException2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("toAppXml fail, metaList, err=");
          localStringBuilder.append(localException2.getMessage());
          ArkAppCenter.a("ArkBabyqCardInfo", localStringBuilder.toString());
        }
      }
      String str2 = this.config;
      if (str2 != null) {
        try
        {
          ((JSONObject)localObject).put("config", new JSONObject(this.config));
        }
        catch (Exception localException3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("toAppXml fail, config, err=");
          localStringBuilder.append(localException3.getMessage());
          ArkAppCenter.a("ArkBabyqCardInfo", localStringBuilder.toString());
        }
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo
 * JD-Core Version:    0.7.0.1
 */