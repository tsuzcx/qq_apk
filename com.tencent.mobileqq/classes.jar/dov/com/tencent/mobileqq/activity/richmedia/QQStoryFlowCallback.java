package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aogn;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import java.io.File;

public class QQStoryFlowCallback
  implements FlowComponentInterface
{
  public static float a;
  public static int a;
  public static Bitmap a;
  public static float b;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 60000;
    d = 12002200;
    e = 20971520;
    f = 240;
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getIntent().hasExtra("extra_upload_temp_directory")) {
      return paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    }
    String str = PublishFileManager.a(paramInt);
    paramActivity.getIntent().putExtra("extra_upload_temp_directory", str);
    return str;
  }
  
  public static String a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.fileSize + "|" + paramLocalMediaInfo.mediaWidth + "|" + paramLocalMediaInfo.mediaHeight + "|" + paramLocalMediaInfo.mDuration + "," + paramLocalMediaInfo.mMimeType + "," + paramLocalMediaInfo.rotation;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt1);
    localIntent.putExtra("from_qqstory", true);
    localIntent.putExtra("ALBUM_NAME", "最近照片");
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("video_refer", paramString1);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", paramBoolean);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
    localIntent.putExtra("troop_uin", paramActivity.getIntent().getLongExtra("troop_uin", 0L));
    if (paramString2 != null)
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString2);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString3 != null)
    {
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramString3);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString4 != null) {
      localIntent.putExtra("launch_take_video_view_extra_value_key", paramString4);
    }
    if (paramInt3 >= 0)
    {
      paramActivity.startActivityForResult(localIntent, paramInt3);
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramInt1, paramString, QIMCameraCaptureActivity.class.getName(), LocalVideoSelectActivity.class.getName(), null, paramBoolean, paramInt2, paramInt3);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6)
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        int i = 1;
        if (paramInt4 == 10002) {
          break label626;
        }
        int j = 2;
        if (paramInt4 == 10004)
        {
          localBundle.putInt("qq_sub_business_id", 101);
          i = 2;
          localBundle.putString("extra_upload_temp_directory", a(paramActivity, i));
          localBundle.putInt("entrance_type", paramInt3);
          localBundle.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
          long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (paramLocalMediaInfo.mMimeType.contains("video"))
          {
            paramString1 = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
            j = paramInt2 - paramInt1;
            paramInt1 = 1;
            if (j / 10000.0F > 1.0F)
            {
              paramInt2 = j / 10000;
              paramInt1 = paramInt2;
              if (j % 10000 >= 1000) {
                paramInt1 = paramInt2 + 1;
              }
            }
            localBundle.putInt("expect_fragment_count", paramInt1);
            if (paramInt1 > 1) {
              break label576;
            }
            break label576;
            paramInt1 = paramInt2 | 0x20000000 | 0x8000000;
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            paramInt1 |= 0x1000000;
            paramInt2 = paramInt1;
            if (MediaCodecDPC.l()) {
              paramInt2 = paramInt1 & 0xFFFFFFDF & 0xFFFFFFFD & 0xFFFFFEFF & 0xFFFFFFEF & 0xFFFFFFFE;
            }
            paramString1 = new EditVideoParams(i, paramInt2, paramString1, localBundle);
            if (l != 0L) {
              paramString1.a.putLong("troop_uin", l);
            }
            paramString1.a.putBoolean("enable_hw_encode", false);
            paramString1.a.putBoolean("ignorePersonalPublish", paramBoolean);
            paramString1.a.putInt("shareGroupType", paramInt5);
            paramString1.a.putString("shareGroupId", paramString2);
            paramString1.a.putString("shareGroupName", paramString3);
            paramLocalMediaInfo = paramString1.a;
            if (paramInt6 != 7) {
              continue;
            }
            paramBoolean = true;
            paramLocalMediaInfo.putBoolean("extra_is_slide_show_video", paramBoolean);
            SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            StoryIntentUtils.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras());
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            paramLocalMediaInfo.putExtra("short_video_entrance_type", 6);
            paramLocalMediaInfo.putExtra("edit_video_way", paramInt6);
            SegmentKeeper.b(0L);
            paramActivity.startActivityForResult(paramLocalMediaInfo, 10002);
          }
        }
        else
        {
          i = j;
          if (paramInt4 != 10009) {
            break label626;
          }
          localBundle.putInt("qq_sub_business_id", 102);
          i = j;
          break label626;
        }
        paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
        break label576;
        boolean bool = TextUtils.isEmpty(paramString2);
        if (!bool)
        {
          break label584;
          paramInt1 |= 0x20000;
          continue;
          paramBoolean = false;
          continue;
          if (paramInt4 == 10002) {
            break label629;
          }
        }
      }
      catch (Exception paramActivity)
      {
        SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label576:
      label584:
      paramInt2 = 268443967;
      if (paramInt5 == 1) {
        paramInt2 = 0x1000213F & 0xFFEFFFFF;
      }
      if (paramInt4 != 10004)
      {
        paramInt1 = paramInt2;
        if (paramInt4 == 10002)
        {
          continue;
          label626:
          continue;
          label629:
          if (paramInt3 != 16) {}
        }
      }
    }
  }
  
  public static boolean a()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (localStoryConfigManager == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
      return false;
    }
    int i = localStoryConfigManager.b();
    if (i == g) {
      return false;
    }
    jdField_a_of_type_Int = ((Integer)localStoryConfigManager.b("localUploadVideoSizeLimit", Integer.valueOf(jdField_a_of_type_Int))).intValue();
    jdField_b_of_type_Int = ((Integer)localStoryConfigManager.b("localUploadVideoMinResolutionLimit", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    c = ((Integer)localStoryConfigManager.b("localUploadVideoDurationLimit", Integer.valueOf(c))).intValue();
    d = ((Integer)localStoryConfigManager.b("localUploadVideoRatioLimit", Integer.valueOf(d))).intValue();
    e = ((Integer)localStoryConfigManager.b("localUploadImageSizeLimit", Integer.valueOf(e))).intValue();
    f = ((Integer)localStoryConfigManager.b("localUploadImageMinResolutionLimit", Integer.valueOf(f))).intValue();
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(jdField_b_of_type_Int), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(f) });
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", new Object[] { Integer.valueOf(g), Integer.valueOf(i) });
    g = localStoryConfigManager.b();
    return true;
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 383
    //   4: lconst_0
    //   5: invokevirtual 161	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   8: lstore 7
    //   10: aload_1
    //   11: ldc_w 385
    //   14: invokevirtual 389	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   17: checkcast 78	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   20: astore 15
    //   22: aload_1
    //   23: ldc 153
    //   25: bipush 99
    //   27: invokevirtual 393	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   30: istore 4
    //   32: aload_1
    //   33: ldc_w 395
    //   36: sipush 10002
    //   39: invokevirtual 393	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   42: istore 5
    //   44: aload 15
    //   46: ifnonnull +14 -> 60
    //   49: new 397	java/lang/IllegalArgumentException
    //   52: dup
    //   53: ldc_w 399
    //   56: invokespecial 402	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload 15
    //   62: getfield 405	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   65: astore 16
    //   67: aload 15
    //   69: getfield 109	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   72: ldc 216
    //   74: invokevirtual 222	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifeq +384 -> 461
    //   80: aload_0
    //   81: invokevirtual 409	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   84: astore 14
    //   86: aload 14
    //   88: getstatic 415	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   91: aconst_null
    //   92: ldc_w 417
    //   95: iconst_1
    //   96: anewarray 218	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload 15
    //   103: getfield 420	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   106: invokestatic 423	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   109: aastore
    //   110: aconst_null
    //   111: invokevirtual 429	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 11
    //   116: aload 11
    //   118: ifnull +571 -> 689
    //   121: aload 11
    //   123: astore 12
    //   125: aload 11
    //   127: invokeinterface 434 1 0
    //   132: ifeq +551 -> 683
    //   135: aload 11
    //   137: astore 12
    //   139: aload 14
    //   141: aload 15
    //   143: getfield 420	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   146: iconst_1
    //   147: aconst_null
    //   148: invokestatic 440	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: astore 13
    //   153: aload 13
    //   155: astore 10
    //   157: aload 13
    //   159: ifnonnull +21 -> 180
    //   162: aload 11
    //   164: astore 12
    //   166: aload 14
    //   168: aload 15
    //   170: getfield 420	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   173: iconst_3
    //   174: aconst_null
    //   175: invokestatic 440	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   178: astore 10
    //   180: aload 11
    //   182: astore 12
    //   184: aload 10
    //   186: astore 13
    //   188: aload 11
    //   190: invokeinterface 443 1 0
    //   195: istore 9
    //   197: iload 9
    //   199: ifne -19 -> 180
    //   202: aload 10
    //   204: astore 12
    //   206: aload 11
    //   208: ifnull +14 -> 222
    //   211: aload 11
    //   213: invokeinterface 446 1 0
    //   218: aload 10
    //   220: astore 12
    //   222: aload 12
    //   224: ifnull +221 -> 445
    //   227: aload 12
    //   229: invokevirtual 451	android/graphics/Bitmap:getWidth	()I
    //   232: aload 12
    //   234: invokevirtual 454	android/graphics/Bitmap:getHeight	()I
    //   237: if_icmple +200 -> 437
    //   240: aload 15
    //   242: getfield 112	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   245: ifeq +192 -> 437
    //   248: aload 12
    //   250: ldc_w 455
    //   253: invokestatic 460	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   256: putstatic 462	dov/com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   259: aload 12
    //   261: invokevirtual 465	android/graphics/Bitmap:recycle	()V
    //   264: lload 7
    //   266: ldc2_w 466
    //   269: lcmp
    //   270: ifge +358 -> 628
    //   273: iload 5
    //   275: sipush 10009
    //   278: if_icmpeq +350 -> 628
    //   281: aload_1
    //   282: ldc_w 266
    //   285: iconst_0
    //   286: invokevirtual 393	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   289: istore 6
    //   291: aload_1
    //   292: ldc_w 268
    //   295: invokevirtual 62	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 10
    //   300: aload_1
    //   301: ldc_w 270
    //   304: invokevirtual 62	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   307: astore 11
    //   309: aload_1
    //   310: ldc_w 264
    //   313: iconst_0
    //   314: invokevirtual 471	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   317: istore 9
    //   319: aload 15
    //   321: getfield 103	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   324: ldc2_w 472
    //   327: lcmp
    //   328: ifgt +293 -> 621
    //   331: iconst_0
    //   332: istore_3
    //   333: aload_0
    //   334: aload 16
    //   336: aload 15
    //   338: iconst_0
    //   339: iload_3
    //   340: iload 4
    //   342: iload 5
    //   344: iload 6
    //   346: aload 10
    //   348: aload 11
    //   350: iload 9
    //   352: iload_2
    //   353: invokestatic 475	dov/com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIIILjava/lang/String;Ljava/lang/String;ZI)V
    //   356: iconst_1
    //   357: ireturn
    //   358: astore 14
    //   360: aconst_null
    //   361: astore 10
    //   363: aconst_null
    //   364: astore 11
    //   366: aload 11
    //   368: astore 12
    //   370: ldc_w 274
    //   373: ldc_w 477
    //   376: iconst_2
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload 15
    //   384: getfield 405	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: aload 14
    //   392: aastore
    //   393: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: aload 10
    //   398: astore 12
    //   400: aload 11
    //   402: ifnull -180 -> 222
    //   405: aload 11
    //   407: invokeinterface 446 1 0
    //   412: aload 10
    //   414: astore 12
    //   416: goto -194 -> 222
    //   419: astore_0
    //   420: aconst_null
    //   421: astore 12
    //   423: aload 12
    //   425: ifnull +10 -> 435
    //   428: aload 12
    //   430: invokeinterface 446 1 0
    //   435: aload_0
    //   436: athrow
    //   437: aload 12
    //   439: putstatic 462	dov/com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   442: goto -178 -> 264
    //   445: invokestatic 484	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   448: getfield 487	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   451: iconst_0
    //   452: invokevirtual 492	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   455: putstatic 462	dov/com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   458: goto -194 -> 264
    //   461: iload 5
    //   463: sipush 10009
    //   466: if_icmpne +5 -> 471
    //   469: iconst_1
    //   470: ireturn
    //   471: iload 5
    //   473: sipush 10002
    //   476: if_icmpeq +93 -> 569
    //   479: iload 5
    //   481: sipush 10004
    //   484: if_icmpne +79 -> 563
    //   487: iconst_1
    //   488: istore 9
    //   490: aload_0
    //   491: aload 16
    //   493: iconst_1
    //   494: iconst_1
    //   495: iconst_1
    //   496: iconst_1
    //   497: iconst_1
    //   498: iconst_0
    //   499: iconst_1
    //   500: iconst_1
    //   501: iload 9
    //   503: iload 9
    //   505: iload 9
    //   507: iconst_2
    //   508: iload 4
    //   510: iconst_5
    //   511: invokestatic 497	dov/com/tencent/biz/qqstory/takevideo/EditPicActivity:a	(Landroid/app/Activity;Ljava/lang/String;ZZZZZZZZZZZIII)Landroid/content/Intent;
    //   514: astore_1
    //   515: aload_1
    //   516: ldc_w 385
    //   519: aload 15
    //   521: invokevirtual 295	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   524: pop
    //   525: aload_1
    //   526: ldc_w 315
    //   529: iload_2
    //   530: invokevirtual 128	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   533: pop
    //   534: iload 5
    //   536: sipush 10004
    //   539: if_icmpne +13 -> 552
    //   542: aload_1
    //   543: ldc_w 499
    //   546: bipush 101
    //   548: invokevirtual 128	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   551: pop
    //   552: aload_0
    //   553: aload_1
    //   554: sipush 10002
    //   557: invokevirtual 180	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   560: goto -91 -> 469
    //   563: iconst_0
    //   564: istore 9
    //   566: goto -76 -> 490
    //   569: aload_0
    //   570: aload 16
    //   572: iconst_1
    //   573: iconst_1
    //   574: iconst_1
    //   575: iconst_1
    //   576: iconst_1
    //   577: iconst_0
    //   578: iconst_1
    //   579: iconst_1
    //   580: iconst_1
    //   581: iconst_1
    //   582: aload_1
    //   583: ldc_w 268
    //   586: invokevirtual 62	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: iconst_1
    //   593: iload 4
    //   595: iconst_0
    //   596: invokestatic 497	dov/com/tencent/biz/qqstory/takevideo/EditPicActivity:a	(Landroid/app/Activity;Ljava/lang/String;ZZZZZZZZZZZIII)Landroid/content/Intent;
    //   599: astore_1
    //   600: aload_1
    //   601: ldc_w 385
    //   604: aload 15
    //   606: invokevirtual 295	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   609: pop
    //   610: aload_0
    //   611: aload_1
    //   612: sipush 10002
    //   615: invokevirtual 180	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   618: goto -149 -> 469
    //   621: sipush 3000
    //   624: istore_3
    //   625: goto -292 -> 333
    //   628: lload 7
    //   630: ldc2_w 466
    //   633: lcmp
    //   634: ifge +26 -> 660
    //   637: iload 5
    //   639: sipush 10009
    //   642: if_icmpne +18 -> 660
    //   645: aload_0
    //   646: lconst_0
    //   647: lload 7
    //   649: aload 16
    //   651: invokestatic 504	dov/com/qq/im/cropvideo/CropVideoActivity:a	(Landroid/app/Activity;JJLjava/lang/String;)V
    //   654: aload_0
    //   655: invokevirtual 507	android/app/Activity:finish	()V
    //   658: iconst_1
    //   659: ireturn
    //   660: iconst_0
    //   661: ireturn
    //   662: astore_0
    //   663: goto -240 -> 423
    //   666: astore 14
    //   668: aconst_null
    //   669: astore 10
    //   671: goto -305 -> 366
    //   674: astore 14
    //   676: aload 13
    //   678: astore 10
    //   680: goto -314 -> 366
    //   683: aconst_null
    //   684: astore 10
    //   686: goto -506 -> 180
    //   689: aconst_null
    //   690: astore 10
    //   692: goto -490 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	paramActivity	Activity
    //   0	695	1	paramIntent	Intent
    //   0	695	2	paramInt	int
    //   332	293	3	i	int
    //   30	564	4	j	int
    //   42	601	5	k	int
    //   289	56	6	m	int
    //   8	640	7	l	long
    //   195	370	9	bool	boolean
    //   155	536	10	localObject1	Object
    //   114	292	11	localObject2	Object
    //   123	315	12	localObject3	Object
    //   151	526	13	localObject4	Object
    //   84	83	14	localContentResolver	android.content.ContentResolver
    //   358	33	14	localException1	Exception
    //   666	1	14	localException2	Exception
    //   674	1	14	localException3	Exception
    //   20	585	15	localLocalMediaInfo	LocalMediaInfo
    //   65	585	16	str	String
    // Exception table:
    //   from	to	target	type
    //   86	116	358	java/lang/Exception
    //   86	116	419	finally
    //   125	135	662	finally
    //   139	153	662	finally
    //   166	180	662	finally
    //   188	197	662	finally
    //   370	396	662	finally
    //   125	135	666	java/lang/Exception
    //   139	153	666	java/lang/Exception
    //   166	180	674	java/lang/Exception
    //   188	197	674	java/lang/Exception
  }
  
  public static boolean a(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    int k = 9999;
    a();
    float f2 = paramLocalMediaInfo.mediaHeight * 1.0F / paramLocalMediaInfo.mediaWidth;
    QQToast localQQToast;
    int j;
    int i;
    if (paramLocalMediaInfo.mMimeType.contains("video")) {
      if (paramLocalMediaInfo.fileSize > jdField_a_of_type_Int)
      {
        localQQToast = QQToast.a(paramActivity, 1, "你选择的视频过大", 0);
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        k = 1;
        j = 1;
        i = 1;
      }
    }
    for (;;)
    {
      StoryReportor.b("upload_local_video", "choose_media_info", 0, j, new String[] { a(paramLocalMediaInfo) });
      String str;
      if (i != 0)
      {
        str = String.valueOf(1);
        label130:
        StoryReportor.a("video_shoot", "chose_video", 0, 0, new String[] { str, String.valueOf(k) });
        if ((i != 0) && (paramLocalMediaInfo.mDuration >= 10500L)) {
          StoryReportor.a("video_shoot", "local_over", 0, 0, new String[0]);
        }
        if (paramLocalMediaInfo.addedDate == 0L)
        {
          paramLocalMediaInfo.addedDate = (new File(paramLocalMediaInfo.path).lastModified() / 1000L);
          if (paramLocalMediaInfo.addedDate == 0L) {
            break label717;
          }
        }
      }
      label717:
      for (i = 0;; i = 1)
      {
        StoryReportor.b("upload_local_video", "media_info_missing", 0, i, new String[] { a(paramLocalMediaInfo) });
        if (localQQToast != null) {
          paramActivity.runOnUiThread(new aogn(localQQToast));
        }
        if (j != 0) {
          break label723;
        }
        return true;
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < jdField_b_of_type_Int)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频分辨率过低", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 1;
          break;
        }
        float f1 = f2;
        if (f2 < 1.0F) {
          f1 = 1.0F / f2;
        }
        if ((f1 < 1.2F) || (f1 > 2.2F))
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的视频比例不符合要求", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 4;
          j = 3;
          i = 1;
          break;
        }
        if (paramLocalMediaInfo.mDuration > c)
        {
          localQQToast = QQToast.a(paramActivity, 1, "请上传不超过1分钟的视频", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          j = 4;
          k = 5;
          i = 1;
          break;
        }
        localQQToast = null;
        j = 0;
        i = 1;
        break;
        if (paramLocalMediaInfo.fileSize > e)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的图片过大", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 1;
          j = 1;
          i = 0;
          break;
        }
        if (Math.min(paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth) < f)
        {
          localQQToast = QQToast.a(paramActivity, 1, "你选择的图片分辨率过低", 0);
          SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
          k = 3;
          j = 2;
          i = 0;
          break;
        }
        if ((f2 >= 0.45D) && (f2 <= 2.2D)) {
          break label725;
        }
        localQQToast = QQToast.a(paramActivity, 1, "你选择的图片比例不符合要求", 0);
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + paramLocalMediaInfo.toString());
        k = 4;
        j = 3;
        i = 0;
        break;
        str = String.valueOf(0);
        break label130;
      }
      label723:
      return false;
      label725:
      localQQToast = null;
      j = 0;
      i = 0;
    }
  }
  
  public String a()
  {
    return "qqstory";
  }
  
  public void a(Activity paramActivity)
  {
    SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick()");
    if (paramActivity == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick() context == null");
      return;
    }
    int i = 99;
    try
    {
      if ((paramActivity instanceof QIMCameraCaptureActivity))
      {
        QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)paramActivity;
        localQIMCameraCaptureActivity.a("612", "2", "0", true);
        i = localQIMCameraCaptureActivity.a();
      }
      StoryReportor.a("video_shoot", "clk_local", 0, 0, new String[0]);
      a(paramActivity, 0, a(), false, i, 10006);
      return;
    }
    catch (Exception paramActivity)
    {
      SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "QQStoryFlowCallback ", paramActivity);
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramActivity = paramActivity.getIntent();
    if (paramInt2 != -1) {}
    for (boolean bool = true;; bool = false)
    {
      paramActivity.putExtra("edit_video_extra_flag_need_remove_temp_dir", bool);
      if (jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        jdField_a_of_type_AndroidGraphicsBitmap = null;
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "mVideoThumbnailCache clear()");
      }
      return;
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */