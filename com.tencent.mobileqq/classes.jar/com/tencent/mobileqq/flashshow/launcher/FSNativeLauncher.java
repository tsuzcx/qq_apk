package com.tencent.mobileqq.flashshow.launcher;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flashshow.activity.FSComponentActivity;
import com.tencent.mobileqq.flashshow.api.IFSQQBaseService;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPageListBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.api.impl.FlashShowServiceApiImpl;
import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;
import com.tencent.mobileqq.flashshow.fragment.FSFolderFragment;
import com.tencent.mobileqq.flashshow.fragment.FSLayerPageFragment;
import com.tencent.mobileqq.flashshow.fragment.FSPersonalHomeFragment;
import com.tencent.mobileqq.flashshow.fragment.list.FSPublicListFragment;
import com.tencent.mobileqq.flashshow.list.blocks.FSMessageListBlock;
import com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest.Builder;
import com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest.Builder;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest.Builder;
import com.tencent.mobileqq.flashshow.sender.FSRequestSender;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSJsUrlUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class FSNativeLauncher
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent.setAction("com.tencent.mobileqq.wink.action.MAIN");
    b(paramContext, paramIntent);
  }
  
  public static void a(Context paramContext, FSFolderBean paramFSFolderBean)
  {
    if (FastClickUtils.a("FSNativeLauncher_launchFolderPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("fs_key_bundle_common_init_bean", paramFSFolderBean);
    paramFSFolderBean = (String)paramFSFolderBean.getAttrs().get("fs_key_bundle_individual_folder_page");
    if ((!TextUtils.isEmpty(paramFSFolderBean)) && (!Boolean.getBoolean(paramFSFolderBean))) {
      localIntent.putExtra("fs_key_bundle_individual_folder_page", Boolean.getBoolean(paramFSFolderBean));
    } else {
      localIntent.putExtra("fs_key_bundle_individual_folder_page", true);
    }
    localIntent.setClass(paramContext, FSComponentActivity.class);
    localIntent.putExtra("public_fragment_class", FSFolderFragment.class.getName());
    b(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, FSLayerPageInitBean paramFSLayerPageInitBean)
  {
    if (FastClickUtils.a("FSNativeLauncher_launchLayerPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("fs_key_bundle_common_init_bean", paramFSLayerPageInitBean);
    localIntent.setClass(paramContext, FSComponentActivity.class);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", FSLayerPageFragment.class.getName());
    b(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, FSPageListBean paramFSPageListBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSMessageListBlock.class.getName());
    a(paramContext, localArrayList, null, paramFSPageListBean);
  }
  
  public static void a(Context paramContext, FSPersonalDetailBean paramFSPersonalDetailBean)
  {
    if (FastClickUtils.a("FSNativeLauncher_launchPersonalDetailPage", 500L)) {
      return;
    }
    if (paramFSPersonalDetailBean != null)
    {
      if (TextUtils.isEmpty(paramFSPersonalDetailBean.getUin())) {
        return;
      }
      a(paramFSPersonalDetailBean.getUin());
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.putExtra("fs_key_bundle_common_init_bean", paramFSPersonalDetailBean);
      localIntent.setClass(paramContext, FSComponentActivity.class);
      localIntent.putExtra("public_fragment_class", FSPersonalHomeFragment.class.getName());
      b(paramContext, localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FSNativeLauncher", 1, "url is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUrl:");
    localStringBuilder.append(paramString);
    QLog.d("FSNativeLauncher", 1, localStringBuilder.toString());
    int i = FSCommonUtil.d(paramString);
    if (i == 0)
    {
      a(paramContext, paramString, null, -1);
      return;
    }
    if (i == 1) {
      FSSchemeLauncher.a(paramContext, paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramContext == null)
    {
      QLog.i("FSNativeLauncher", 1, "launchFSHybirdActivity context == null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("FSNativeLauncher", 1, "launchFSHybirdActivity url isEmpty");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchFSHybirdActivity url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FSNativeLauncher", 1, ((StringBuilder)localObject).toString());
    if (!FSJsUrlUtils.a(paramString))
    {
      QLog.i("FSNativeLauncher", 1, "launchFSHybirdActivity url is Invalid");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchFSHybirdActivity:");
    ((StringBuilder)localObject).append(paramString);
    if (FastClickUtils.a(((StringBuilder)localObject).toString(), 1500L))
    {
      QLog.i("FSNativeLauncher", 1, "launchFSHybirdActivity is fast double click");
      return;
    }
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    paramString = FlashShowServiceApiImpl.getQQService().handleFSHybirdActivityIntent(paramContext, paramString, (Intent)localObject, paramInt);
    paramString.putExtra("web_color_note_type", 3);
    if ((paramContext instanceof FragmentActivity))
    {
      ((FragmentActivity)paramContext).startActivityForResult(paramString, paramInt);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  private static void a(Context paramContext, ArrayList<String> paramArrayList, ArrayList paramArrayList1, FSPageListBean paramFSPageListBean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, FSComponentActivity.class);
    localIntent.putExtra("public_fragment_class", FSPublicListFragment.class.getName());
    localIntent.putExtra("public_list_block_class_array", paramArrayList);
    localIntent.putExtra("public_list_init_data", paramArrayList1);
    localIntent.putExtra("key_bundle_common_init_bean", paramFSPageListBean);
    localIntent.addFlags(268435456);
    b(paramContext, localIntent);
  }
  
  private static void a(String paramString)
  {
    FSRequestCall localFSRequestCall = FSRequestSender.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("3003");
    localStringBuilder.append(paramString);
    localFSRequestCall.a(localStringBuilder.toString(), new FSGetMainPageRequest.Builder(paramString).openCache().build()).a();
    localFSRequestCall = FSRequestSender.a().b();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("3004");
    localStringBuilder.append(paramString);
    localFSRequestCall.a(localStringBuilder.toString(), new FSGetFeedListLikeRequest.Builder(paramString).openCache().build()).a();
  }
  
  private static void b(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      QLog.e("FSNativeLauncher", 1, "context is null,cannot start activity");
      return;
    }
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher
 * JD-Core Version:    0.7.0.1
 */