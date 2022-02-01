package cooperation.peak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.richmediabrowser.utils.DataUtils;
import com.tencent.util.BinderWarpper;

public final class PeakUtils
{
  public static final SparseBooleanArray a;
  public static PreloadProcHitSession a;
  public static String a;
  public static final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = RichMediaBrowserConstants.EXTRA_IS_REPLY_SRC_MSG_EXIST;
    jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 7, 9 };
    int i = 0;
    while (i < 10)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int m = arrayOfInt.length;
      int j = 0;
      for (;;)
      {
        int k = 1;
        if (j >= m) {
          break;
        }
        if (i == arrayOfInt[j] - 1)
        {
          jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, true);
          j = k;
          break label94;
        }
        j += 1;
      }
      j = 0;
      label94:
      if (j == 0) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
      }
      i += 1;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, IAIOImageProvider paramIAIOImageProvider, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool1 = localBundle.getBoolean("extra.ENTER_NEW_GALLERY");
    if (bool1) {
      paramBundle = new Intent(paramContext, com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.class);
    } else {
      paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
    }
    boolean bool2 = paramContext instanceof PublicFragmentActivity;
    int i;
    if ((bool2) && ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!localBundle.getBoolean("extra.EXTRA_NOT_CLEAR_TOP", false)) && (paramInt2 != 3) && (paramInt2 != 2) && (i == 0)) {
      paramBundle.addFlags(603979776);
    } else {
      paramBundle.addFlags(536870912);
    }
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramIAIOImageProvider.asBinder()));
    if (bool1) {
      localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", DataUtils.a(paramAIORichMediaData));
    } else {
      localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
    }
    localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
    if (paramAIORichMediaData != null) {
      localBundle.putBoolean(RichMediaBrowserConstants.EXTRA_IS_MIXED_MSG, paramAIORichMediaData.l);
    }
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity)))
    {
      if ((paramContext instanceof ChatHistoryActivity))
      {
        localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      }
      else if ((paramContext instanceof ChatHistory))
      {
        localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      }
      else if (bool2)
      {
        if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment))
        {
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
          localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
        }
      }
      else if ((paramContext instanceof ChatHistoryFileActivity))
      {
        localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      }
    }
    else
    {
      if ((paramContext instanceof MultiForwardActivity))
      {
        paramIAIOImageProvider = ((BaseActivity)paramContext).getAppInterface();
        if ((paramIAIOImageProvider instanceof QQAppInterface))
        {
          localBundle.putBoolean("extra.FROM_AIO", true);
          localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          MultiForwardActivity localMultiForwardActivity = (MultiForwardActivity)paramContext;
          localBundle.putString("uin", localMultiForwardActivity.getChatFragment().a().a().jdField_a_of_type_JavaLangString);
          String str = localBundle.getString("extra.GROUP_UIN");
          if ((str != null) && (((QQAppInterface)paramIAIOImageProvider).getTroopMask(str) == 2)) {
            localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          }
          if ((paramAIORichMediaData != null) && (paramAIORichMediaData.k))
          {
            localBundle.putLong("key_multi_forward_seq", localMultiForwardActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
            localMultiForwardActivity.a.a = true;
          }
        }
      }
      else
      {
        localBundle.putBoolean("extra.FROM_AIO", true);
        localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)paramContext).getClass().getName());
      }
      localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
    }
    if (ChatHistoryActivity.a(paramContext, localBundle)) {
      paramInt1 = 38;
    }
    paramBundle.putExtras(localBundle);
    if (paramInt1 < 0) {
      paramContext.startActivity(paramBundle);
    } else if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
    }
    paramContext = jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
    if (paramContext != null) {
      paramContext.b();
    }
  }
  
  public static void a(Context paramContext, @NonNull Bundle paramBundle, @NonNull IAIOImageProvider paramIAIOImageProvider, @NonNull AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramBundle.putBoolean("extra.EXTRA_FORBID_FETCH_ALL_IMAGE", paramBoolean);
    paramBundle.putParcelableArray("extra.EXTRA_CURRENT_IMAGE_LIST", DataUtils.a(paramArrayOfAIORichMediaData));
    a(paramContext, paramBundle, paramIAIOImageProvider, (AIORichMediaData)null, paramInt1, paramInt2);
  }
  
  public static void b(Context paramContext, Bundle paramBundle, IAIOImageProvider paramIAIOImageProvider, AIORichMediaData paramAIORichMediaData, int paramInt1, int paramInt2)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramIAIOImageProvider.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIORichMediaData);
    localBundle.putBoolean("extra.IS_GOTO_IMAGELIST", true);
    localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
    paramBundle.putExtras(localBundle);
    boolean bool = localBundle.getBoolean("extra.RIGHT_EXIT_TRANSITION", false);
    if (paramInt1 < 0)
    {
      paramContext.startActivity(paramBundle);
      if ((bool) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).overridePendingTransition(2130772074, 2130772084);
      }
    }
    else if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramBundle, paramInt1);
    }
    paramContext = jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
    if (paramContext != null) {
      paramContext.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.peak.PeakUtils
 * JD-Core Version:    0.7.0.1
 */