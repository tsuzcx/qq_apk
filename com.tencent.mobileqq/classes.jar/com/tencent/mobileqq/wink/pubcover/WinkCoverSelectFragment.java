package com.tencent.mobileqq.wink.pubcover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.WinkTAVCutBaseFragment;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderImpl;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.ScrollConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.TimeBarConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.VideoTrackConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.ActiveChangedEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.DragDropViewEmptyClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventObserver;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelScrollEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.SelectChangedEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackCutEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackEmptyClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportManager;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ISessionListener;
import com.tencent.videocut.utils.DensityUtils;
import com.tencent.videocut.utils.ScreenUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class WinkCoverSelectFragment
  extends WinkTAVCutBaseFragment
  implements View.OnClickListener, PanelEventObserver
{
  private final ISessionListener A = new WinkCoverSelectFragment.2(this);
  protected String f;
  protected ArrayList<LocalMediaInfo> g;
  private WinkCoverSelectViewModel h;
  private ImageView i;
  private FrameLayout j;
  private ImageView k;
  private TextView l;
  private RelativeLayout m;
  private RelativeLayout n;
  private RoundCornerImageView o;
  private ImageView p;
  private TimelinePanel q;
  private TimelinePanelViewController r;
  private TimelineViewModel s;
  private VideoTrackController t;
  private DragDropScrollViewController u;
  private String v;
  private long w = 0L;
  private boolean x = true;
  private Pair<Integer, Integer> y;
  private final IPlayer.PlayerListener z = new WinkCoverSelectFragment.1(this);
  
  @RequiresApi(api=17)
  private void A()
  {
    if (this.s == null)
    {
      this.s = ((TimelineViewModel)a(TimelineViewModel.class));
      this.s.a(this.h.b(), this.h.c(), this.h.e(), this.h.d());
    }
    this.s.c().observe(getViewLifecycleOwner(), new -..Lambda.WinkCoverSelectFragment.DtvfOIpoPH9eBJz-Tg1mUtINFmk(this));
    this.s.b().observe(getViewLifecycleOwner(), new -..Lambda.WinkCoverSelectFragment.nMX_U1MC6JberI9TDZYCmv87az4(this));
    this.h.g().observe(getViewLifecycleOwner(), new -..Lambda.WinkCoverSelectFragment.8Oat3UOSMIEW_oG9P_mJpsBG1hc(this));
  }
  
  private void B()
  {
    if (!TextUtils.isEmpty(this.v))
    {
      Uri localUri = Uri.fromFile(new File(this.v));
      this.i.setImageURI(localUri);
      this.o.setBorder(true);
      this.o.setColor(Color.parseColor("#00B4FF"));
      this.o.setCorner(ViewUtils.dip2px(6.0F));
      this.o.setBorderWidth(ViewUtils.dip2px(4.0F));
      this.o.setImageURI(localUri);
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      this.q.setVisibility(8);
      this.n.setVisibility(0);
      this.m.setVisibility(8);
      return;
    }
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    this.q.setVisibility(0);
    this.n.setVisibility(8);
    this.m.setVisibility(0);
  }
  
  private String C()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.x = getActivity().getIntent().getBooleanExtra("key_is_video_progress_cover", true);
      if (!this.x) {
        return getActivity().getIntent().getStringExtra("key_video_cover_path");
      }
    }
    return null;
  }
  
  private void D()
  {
    this.x = true;
    if (!TextUtils.isEmpty(this.v))
    {
      this.x = false;
      a(a(BitmapFactory.decodeFile(this.v), 720, 1280));
      return;
    }
    this.x = true;
    E();
  }
  
  private void E()
  {
    ThreadManager.getFileThreadHandler().post(new WinkCoverSelectFragment.3(this));
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Bitmap localBitmap1;
      try
      {
        i1 = paramBitmap.getWidth();
        i2 = paramBitmap.getHeight();
        double d1 = i1;
        double d2 = i2;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = paramInt1;
        double d3 = paramInt2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d1 > d2 / d3)
        {
          paramInt1 = paramInt1 * i2 / paramInt2;
          paramInt2 = i2;
        }
        else
        {
          paramInt2 = paramInt2 * i1 / paramInt1;
          paramInt1 = i1;
        }
        if (i1 <= paramInt1) {
          break label201;
        }
        i1 = (i1 - paramInt1) / 2;
        if (i2 <= paramInt2) {
          break label207;
        }
        i2 = (i2 - paramInt2) / 2;
        localBitmap1 = Bitmap.createBitmap(paramBitmap, i1, i2, paramInt1, paramInt2, null, false);
        try
        {
          paramBitmap.recycle();
          return localBitmap1;
        }
        catch (Exception paramBitmap)
        {
          Bitmap localBitmap2 = paramBitmap;
        }
        paramBitmap = new StringBuilder();
      }
      catch (Exception localException)
      {
        localBitmap1 = paramBitmap;
      }
      paramBitmap.append("centerCropBitmap, exception = ");
      paramBitmap.append(localException.toString());
      WinkQLog.a("WinkCoverSelectFragment", paramBitmap.toString());
      return localBitmap1;
      label201:
      int i1 = 0;
      continue;
      label207:
      int i2 = 0;
    }
  }
  
  private void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
    localIntent.putExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", false);
    localIntent.putExtra("WINK_PHOTO_LIST_SELECT_ENTRANCE", 1);
    localIntent.putExtra("BUNDLE_KEY_CIRCLE_SINGLE_PICK_MODE", true);
    localIntent.putExtra("BUNDLE_KEY_CIRCLE_HIDE_PHOTOLIST_TAB", true);
    localIntent.putExtra("BUNDLE_KEY_CIRCLE_DEFAULT_SELECT_TAB", 2);
    localIntent.setClass(paramContext, QQWinkActivity.class);
    localIntent.putExtra("public_fragment_class", WinkCirclePhotoListFragment.class.getName());
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).startActivityForResult(localIntent, 9);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_PATH());
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.v = paramIntent;
        B();
        paramIntent = new StringBuilder();
        paramIntent.append("handleSelectCoverFromAlbum, coverPathFromAlbum = ");
        paramIntent.append(this.v);
        AEQLog.a("WinkCoverSelectFragment", paramIntent.toString());
      }
    }
    else
    {
      AEQLog.a("WinkCoverSelectFragment", "handleSelectCoverFromAlbum, data == null");
    }
  }
  
  /* Error */
  private void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +28 -> 29
    //   4: ldc_w 311
    //   7: ldc_w 382
    //   10: invokestatic 384	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   17: iconst_0
    //   18: invokevirtual 387	androidx/fragment/app/FragmentActivity:setResult	(I)V
    //   21: aload_0
    //   22: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   25: invokevirtual 390	androidx/fragment/app/FragmentActivity:finish	()V
    //   28: return
    //   29: new 299	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc_w 392
    //   41: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload_1
    //   47: invokevirtual 281	android/graphics/Bitmap:getWidth	()I
    //   50: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: ldc_w 397
    //   58: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   67: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 311
    //   74: aload_2
    //   75: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 399	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 299	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: getstatic 403	com/tencent/mobileqq/wink/edit/base/AEEditorPath$EDITOR$FILES:g	Ljava/lang/String;
    //   93: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: getstatic 406	java/io/File:separator	Ljava/lang/String;
    //   101: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: aload_0
    //   107: getfield 408	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:f	Ljava/lang/String;
    //   110: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: ldc_w 410
    //   118: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   126: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: ldc_w 421
    //   134: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore_2
    //   143: new 143	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore_3
    //   152: aload_3
    //   153: invokevirtual 425	java/io/File:getParentFile	()Ljava/io/File;
    //   156: invokevirtual 429	java/io/File:exists	()Z
    //   159: ifne +22 -> 181
    //   162: aload_3
    //   163: invokevirtual 425	java/io/File:getParentFile	()Ljava/io/File;
    //   166: invokevirtual 432	java/io/File:mkdirs	()Z
    //   169: ifne +12 -> 181
    //   172: ldc_w 311
    //   175: ldc_w 434
    //   178: invokestatic 384	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: invokevirtual 437	java/io/File:createNewFile	()Z
    //   185: ifne +12 -> 197
    //   188: ldc_w 311
    //   191: ldc_w 439
    //   194: invokestatic 384	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_1
    //   198: aload_2
    //   199: invokestatic 445	com/tencent/mobileqq/utils/FileUtils:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   202: ifeq +86 -> 288
    //   205: new 299	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   212: astore_3
    //   213: aload_3
    //   214: ldc_w 447
    //   217: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_3
    //   222: aload_2
    //   223: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc_w 311
    //   230: aload_3
    //   231: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 399	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: new 231	android/content/Intent
    //   240: dup
    //   241: invokespecial 320	android/content/Intent:<init>	()V
    //   244: astore_3
    //   245: aload_3
    //   246: ldc 237
    //   248: aload_2
    //   249: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   252: pop
    //   253: aload_3
    //   254: ldc_w 449
    //   257: aload_0
    //   258: invokevirtual 451	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:n	()Ljava/lang/String;
    //   261: invokevirtual 359	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   264: pop
    //   265: aload_3
    //   266: ldc 229
    //   268: aload_0
    //   269: getfield 58	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:x	Z
    //   272: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   275: pop
    //   276: aload_0
    //   277: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   280: iconst_m1
    //   281: aload_3
    //   282: invokevirtual 454	androidx/fragment/app/FragmentActivity:setResult	(ILandroid/content/Intent;)V
    //   285: goto +20 -> 305
    //   288: ldc_w 311
    //   291: ldc_w 456
    //   294: invokestatic 384	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   301: iconst_0
    //   302: invokevirtual 387	androidx/fragment/app/FragmentActivity:setResult	(I)V
    //   305: aload_1
    //   306: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   309: goto +55 -> 364
    //   312: astore_1
    //   313: goto +59 -> 372
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 459	java/lang/Exception:printStackTrace	()V
    //   321: new 299	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   328: astore_2
    //   329: aload_2
    //   330: ldc_w 461
    //   333: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_2
    //   338: aload_1
    //   339: invokevirtual 309	java/lang/Exception:toString	()Ljava/lang/String;
    //   342: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: ldc_w 311
    //   349: aload_2
    //   350: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 384	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   360: iconst_0
    //   361: invokevirtual 387	androidx/fragment/app/FragmentActivity:setResult	(I)V
    //   364: aload_0
    //   365: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   368: invokevirtual 390	androidx/fragment/app/FragmentActivity:finish	()V
    //   371: return
    //   372: aload_0
    //   373: invokevirtual 221	com/tencent/mobileqq/wink/pubcover/WinkCoverSelectFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   376: invokevirtual 390	androidx/fragment/app/FragmentActivity:finish	()V
    //   379: aload_1
    //   380: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	WinkCoverSelectFragment
    //   0	381	1	paramBitmap	Bitmap
    //   36	314	2	localObject1	Object
    //   151	131	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	181	312	finally
    //   181	197	312	finally
    //   197	285	312	finally
    //   288	305	312	finally
    //   305	309	312	finally
    //   317	364	312	finally
    //   29	181	316	java/lang/Exception
    //   181	197	316	java/lang/Exception
    //   197	285	316	java/lang/Exception
    //   288	305	316	java/lang/Exception
    //   305	309	316	java/lang/Exception
  }
  
  private void a(View paramView)
  {
    VideoReport.setElementId(paramView, "em_xsj_save_button");
    VideoReport.setElementParams(this, WinkDTParamBuilder.buildElementParams());
    VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
  }
  
  private void o()
  {
    if (getActivity().getIntent().getExtras() != null)
    {
      this.f = getActivity().getIntent().getStringExtra("key_wink_video_mission_id");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParamsFromIntent, missionId = ");
      localStringBuilder.append(this.f);
      WinkQLog.a("WinkCoverSelectFragment", localStringBuilder.toString());
      this.v = C();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParamsFromIntent, coverPathFromAlbum = ");
      localStringBuilder.append(this.v);
      WinkQLog.a("WinkCoverSelectFragment", localStringBuilder.toString());
      this.g = getActivity().getIntent().getParcelableArrayListExtra("localMediaInfos");
    }
  }
  
  @RequiresApi(api=21)
  private void u()
  {
    if (this.h == null) {
      this.h = ((WinkCoverSelectViewModel)a(WinkCoverSelectViewModel.class));
    }
    this.h.a(this.a, this.b);
    this.h.a(this.g);
    this.h.a(this.f);
    w();
    x();
    y();
    A();
    this.h.b(this.w);
    this.y = WinkExportManager.a(this.h.f(), this.h.f().getOriginMediaInfos());
  }
  
  @RequiresApi(api=21)
  private void w()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      ((TimelinePanelViewController)localObject).a(this.q);
      localObject = new VideoTrackConfig();
      localObject = ((VideoTrackConfig)localObject).a(((VideoTrackConfig)localObject).d(), ((VideoTrackConfig)localObject).e(), 35.599998F, ((VideoTrackConfig)localObject).f(), ((VideoTrackConfig)localObject).g(), ((VideoTrackConfig)localObject).h(), false);
      LayoutConfig localLayoutConfig = new LayoutConfig();
      localLayoutConfig = localLayoutConfig.a(ScreenUtils.a() / 2, 0.0F, localLayoutConfig.f(), localLayoutConfig.g(), Color.parseColor("#00B4FF"));
      localObject = new CommonConfig(new ScrollConfig(), localLayoutConfig, (VideoTrackConfig)localObject, new TimeBarConfig());
      this.r.a((CommonConfig)localObject);
      this.r.f();
      this.r.i().a(this, -..Lambda.WinkCoverSelectFragment.nvIv7fYhVBgl0-ceEeMNQ8EGcgY.INSTANCE);
    }
  }
  
  private void x()
  {
    VideoTrackContainerView localVideoTrackContainerView = new VideoTrackContainerView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DensityUtils.a.a(56.0F));
    localLayoutParams.topMargin = DensityUtils.a.a(6.0F);
    localLayoutParams.bottomMargin = DensityUtils.a.a(6.0F);
    localVideoTrackContainerView.setLayoutParams(localLayoutParams);
    this.t.a(localVideoTrackContainerView);
    localVideoTrackContainerView.setItemOnLongClickListener(new -..Lambda.WinkCoverSelectFragment.tNMDoFGdOUgjj7sBVIrn6zz4TdE(this));
  }
  
  private void y()
  {
    DragDropScrollView localDragDropScrollView = new DragDropScrollView(getContext());
    localDragDropScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.u.a(localDragDropScrollView);
  }
  
  private void z()
  {
    this.r = new TimelinePanelViewController();
    this.t = new VideoTrackController(ThumbnailProviderImpl.a);
    this.u = new DragDropScrollViewController();
    this.r.a(this.t);
    this.r.a(this.u);
  }
  
  protected String a()
  {
    WinkEditDataWrapper localWinkEditDataWrapper = WinkEditDataHelper.a(getActivity().getIntent().getStringExtra("key_wink_video_mission_id"));
    if (localWinkEditDataWrapper != null) {
      return localWinkEditDataWrapper.getTemplateFilePath();
    }
    return null;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
  }
  
  public void a(@NotNull PanelEvent paramPanelEvent)
  {
    if ((paramPanelEvent instanceof PanelScrollEvent))
    {
      TimelineViewModel localTimelineViewModel = this.s;
      paramPanelEvent = (PanelScrollEvent)paramPanelEvent;
      localTimelineViewModel.a(paramPanelEvent.a(), paramPanelEvent.b());
      return;
    }
    if ((paramPanelEvent instanceof VideoTrackCutEvent))
    {
      this.s.a((VideoTrackCutEvent)paramPanelEvent);
      return;
    }
    if ((!(paramPanelEvent instanceof DragDropViewEmptyClickEvent)) && (!(paramPanelEvent instanceof VideoTrackEmptyClickEvent)) && (!(paramPanelEvent instanceof SelectChangedEvent)))
    {
      boolean bool = paramPanelEvent instanceof ActiveChangedEvent;
      return;
    }
    this.s.k();
  }
  
  public String b()
  {
    return null;
  }
  
  protected int c()
  {
    return 2131629699;
  }
  
  protected List<Part> d()
  {
    return null;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      getActivity().setResult(0);
      getActivity().finish();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected FrameLayout e()
  {
    return (FrameLayout)getView().findViewById(2131449532);
  }
  
  protected ISessionListener f()
  {
    return this.A;
  }
  
  protected IPlayer.PlayerListener g()
  {
    return this.z;
  }
  
  protected boolean i()
  {
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  protected int j()
  {
    return 0;
  }
  
  protected boolean k()
  {
    return false;
  }
  
  public String l()
  {
    return "pg_xsj_publish_cover_page";
  }
  
  protected String n()
  {
    Bundle localBundle = getArguments();
    if (getActivity().getIntent().getExtras() != null) {
      localObject1 = getActivity().getIntent().getStringExtra("key_video_media_path");
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localBundle.containsKey("key_video_media_path")) {
          localObject2 = localBundle.getString("key_video_media_path");
        }
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getMediaPath, mediaPath = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    AEQLog.a("WinkCoverSelectFragment", ((StringBuilder)localObject1).toString());
    return localObject2;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 9) && (paramInt2 == -1)) {
      a(paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131448310)
    {
      getActivity().setResult(0);
      getActivity().finish();
    }
    else if (i1 == 2131448352)
    {
      D();
    }
    else if (i1 == 2131448731)
    {
      a(paramView.getContext());
    }
    else if (i1 == 2131448312)
    {
      this.v = null;
      B();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.h.b().b(this.A);
    this.h.b().g();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  @RequiresApi(api=21)
  public void onViewCreated(@NonNull View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    z();
    this.j = ((FrameLayout)paramView.findViewById(2131449532));
    this.i = ((ImageView)paramView.findViewById(2131449531));
    this.k = ((ImageView)paramView.findViewById(2131448310));
    this.l = ((TextView)paramView.findViewById(2131448352));
    this.m = ((RelativeLayout)paramView.findViewById(2131448731));
    this.n = ((RelativeLayout)paramView.findViewById(2131448737));
    this.o = ((RoundCornerImageView)paramView.findViewById(2131448362));
    this.p = ((ImageView)paramView.findViewById(2131448312));
    this.q = ((TimelinePanel)paramView.findViewById(2131449845));
    a(this.l);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.p.setOnClickListener(this);
    u();
    B();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment
 * JD-Core Version:    0.7.0.1
 */