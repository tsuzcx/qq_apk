package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.musicgene.AlbumDecodeHandler;
import com.tencent.mobileqq.musicgene.AlbumDecodeHandler.OnDecodeCompleteCallback;
import com.tencent.mobileqq.musicgene.BitmapOptionUtil;
import com.tencent.mobileqq.musicgene.QQMusicConst;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenTogetherPlayFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  boolean A = false;
  String B;
  AlbumDecodeHandler.OnDecodeCompleteCallback C = new ListenTogetherPlayFragment.1(this);
  ListenTogetherObserver D = new ListenTogetherPlayFragment.3(this);
  View.OnTouchListener E = new ListenTogetherPlayFragment.4(this);
  View a;
  View b;
  TextView c;
  TextView d;
  TextView e;
  View f;
  TextView g;
  ImageView h;
  ImageView i;
  ImageView j;
  ImageView k;
  View l;
  LyricViewDetail m;
  LyricViewController n;
  URLImageView o;
  ImageView p;
  ImageView q;
  ImageView[] r = new ImageView[5];
  AvatarLayout s;
  FileBrowserMiniAIOHelper t;
  ListenTogetherHandler u;
  ListenTogetherManager v;
  QQAppInterface w;
  ISong x;
  ListenTogetherSession y;
  boolean z;
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "Grp_AIO";
    }
    if (paramInt == 2) {
      return "c2c_AIO";
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!isAdded()) {
        return;
      }
      boolean bool = QLog.isColorLevel();
      int i1 = 0;
      if (bool) {
        QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetColors [0x%x 0x%x]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      int i2 = Color.argb(0, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1));
      localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, i2, i2, i2, i2, i2, paramInt1 });
      this.p.setBackgroundDrawable((Drawable)localObject);
      this.a.setBackgroundColor(paramInt1);
      if (paramBoolean)
      {
        this.o.setBackgroundColor(paramInt1);
        this.p.setImageResource(2130841369);
        this.p.setScaleType(ImageView.ScaleType.CENTER);
      }
      else
      {
        this.o.setBackgroundColor(0);
        this.p.setImageDrawable(null);
      }
      paramInt1 = Color.argb(128, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
      this.c.setTextColor(paramInt2);
      this.d.setTextColor(paramInt2);
      this.g.setTextColor(paramInt2);
      this.e.setTextColor(paramInt2);
      this.m.getLyricViewInternal().setLyricHilightColor(paramInt2);
      this.m.getLyricViewInternal().setLyricColor(paramInt1);
      this.h.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.i.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.j.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.k.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.q.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      localObject = this.s;
      paramInt1 = i1;
      if (localObject != null)
      {
        a(((DynamicAvatarView)((AvatarLayout)localObject).findViewById(2131429335)).getBackground(), paramInt2);
        paramInt1 = i1;
      }
      for (;;)
      {
        localObject = this.r;
        if (paramInt1 >= localObject.length) {
          break;
        }
        localObject = localObject[paramInt1];
        a(((ImageView)localObject).getBackground(), paramInt2);
        ((ImageView)localObject).setTag(Integer.valueOf(paramInt2));
        paramInt1 += 1;
      }
      localObject = getResources().getDrawable(2130841370);
      ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.e.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      if (this.y.m == 1) {
        this.g.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      } else {
        this.g.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      localObject = this.e.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00899", a(paramInt), "", paramString2, paramString3, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(Context paramContext, ListenTogetherSession paramListenTogetherSession, ISong paramISong, boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("session", paramListenTogetherSession);
    localIntent.putExtra("song", paramISong);
    localIntent.putExtra("isAdmin", paramBoolean);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    } else if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    if (paramDrawable != null) {
      paramDrawable.invalidateSelf();
    }
  }
  
  private void a(View paramView)
  {
    this.c = ((TextView)paramView.findViewById(2131446156));
    this.d = ((TextView)paramView.findViewById(2131446185));
    this.h = ((ImageView)paramView.findViewById(2131440389));
    this.m = ((LyricViewDetail)paramView.findViewById(2131437791));
    this.o = ((URLImageView)paramView.findViewById(2131439064));
    this.p = ((ImageView)paramView.findViewById(2131439055));
    this.q = ((ImageView)paramView.findViewById(2131439054));
    this.b = paramView.findViewById(2131435747);
    this.a = paramView.findViewById(2131445159);
    this.g = ((TextView)paramView.findViewById(2131447684));
    this.f = paramView.findViewById(2131447678);
    this.l = paramView.findViewById(2131437511);
    this.i = ((ImageView)paramView.findViewById(2131440388));
    this.j = ((ImageView)paramView.findViewById(2131440381));
    this.k = ((ImageView)paramView.findViewById(2131440380));
    int i1 = 0;
    while (i1 < 5)
    {
      Object localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("head");
      localStringBuilder.append(i1);
      localObject = (ImageView)((View)localObject).findViewWithTag(localStringBuilder.toString());
      this.r[i1] = localObject;
      i1 += 1;
    }
    this.e = ((TextView)paramView.findViewById(2131432113));
    ((ViewGroup.MarginLayoutParams)this.q.getLayoutParams()).topMargin = AIOUtils.b(31.0F, getResources());
    this.q.setImageResource(2130846990);
    this.q.setBackgroundResource(2130838762);
    a(this.q.getBackground(), 1275068416);
    if (!b())
    {
      this.h.setAlpha(0.2F);
      this.i.setVisibility(4);
      this.k.setVisibility(4);
      this.j.setVisibility(4);
    }
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnTouchListener(this.E);
    this.i.setOnTouchListener(this.E);
    this.k.setOnTouchListener(this.E);
    this.j.setOnTouchListener(this.E);
    this.q.setOnTouchListener(this.E);
    this.e.setOnTouchListener(this.E);
    this.f.setOnTouchListener(this.E);
    this.n = new LyricViewController(this.m);
    if (ScreenUtil.SCREEN_WIDTH > 0) {
      paramView.findViewById(2131439053).getLayoutParams().height = ScreenUtil.SCREEN_WIDTH;
    }
    d();
  }
  
  private void a(ISong paramISong)
  {
    this.c.setText(paramISong.b());
    Object localObject1 = paramISong.f();
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool1 = true;
    if ((!bool2) && (Patterns.WEB_URL.matcher((CharSequence)localObject1).matches()))
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "original";
      localObject2 = URLDrawable.getDrawable(paramISong.f(), (URLDrawable.URLDrawableOptions)localObject2);
      Object localObject3 = AlbumDecodeHandler.a(paramISong.f());
      if (localObject3 != null)
      {
        a(((Integer)((List)localObject3).get(0)).intValue(), ((Integer)((List)localObject3).get(1)).intValue(), false);
        i1 = 1;
      }
      else
      {
        localObject3 = new AlbumDecodeHandler((String)localObject1, this.C, null);
        if (((URLDrawable)localObject2).getStatus() == 1)
        {
          Drawable localDrawable = ((URLDrawable)localObject2).getCurrDrawable();
          if ((localDrawable instanceof RegionDrawable)) {
            ThreadManager.postImmediately(new ListenTogetherPlayFragment.2(this, (AlbumDecodeHandler)localObject3, ((RegionDrawable)localDrawable).getBitmap()), null, true);
          }
          i1 = 2;
        }
        else
        {
          i1 = 3;
          ((URLDrawable)localObject2).setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
        }
      }
      this.o.setImageDrawable((Drawable)localObject2);
    }
    else
    {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", new Object[] { Integer.valueOf(i1), localObject1 }));
    }
    localObject1 = MusicInfo.a(paramISong.g());
    int i1 = MusicInfo.b(paramISong.g());
    if (paramISong.h() > 0L)
    {
      paramISong = MusicInfo.a(this.w, this.y.m, this.y.n, paramISong.h());
      this.e.setVisibility(4);
      i1 = 0;
    }
    else
    {
      this.e.setVisibility(0);
      paramISong = (ISong)localObject1;
    }
    localObject1 = this.e;
    if (((TextView)localObject1).getVisibility() != 0) {
      bool1 = false;
    }
    ((TextView)localObject1).setClickable(bool1);
    this.d.setText(paramISong);
    if (i1 != 0)
    {
      this.d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i1), null, null, null);
      return;
    }
    this.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = (String)this.m.getTag();
    if (TextUtils.isEmpty(paramString2))
    {
      this.m.setVisibility(4);
      this.n.b();
    }
    else
    {
      int i1;
      if ((this.m.getLyricViewInternal().getLyric() != null) && (Utils.a(str, paramString1)))
      {
        i1 = 0;
      }
      else
      {
        a(paramString2, this.m);
        this.m.setTag(paramString1);
        i1 = 1;
      }
      this.m.setVisibility(0);
      long l1 = this.v.j();
      int i2 = (int)l1;
      if (paramInt == 1)
      {
        boolean bool = this.n.d();
        if (!bool) {
          this.n.a();
        }
        paramString1 = new StringBuilder();
        paramString1.append("updateLyricPosition() try to seek! playPosition:");
        paramString1.append(l1);
        paramString1.append(" seekPosition:");
        paramString1.append(i2);
        paramString1.append(" isPlaying:");
        paramString1.append(bool);
        QLog.i("ListenTogetherPlayFragment", 1, paramString1.toString());
        if ((i2 >= 0) || (i1 != 0))
        {
          paramString1 = this.n;
          if (i2 >= 0) {
            i1 = i2;
          } else {
            i1 = 0;
          }
          paramString1.a(i1);
        }
      }
      else if (2 == paramInt)
      {
        if (i2 >= 0) {
          this.n.a(i2);
        }
        this.n.c();
      }
      else
      {
        this.n.b();
      }
    }
    if (paramInt == 1) {
      this.h.setImageResource(2130841373);
    } else {
      this.h.setImageResource(2130841374);
    }
    if (!b())
    {
      this.h.setAlpha(0.2F);
      this.i.setVisibility(4);
      this.k.setVisibility(4);
      this.j.setVisibility(4);
    }
    else
    {
      this.h.setAlpha(1.0F);
      this.i.setVisibility(0);
      this.k.setVisibility(0);
      this.j.setVisibility(0);
    }
    paramInt = this.y.j;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.i.setImageResource(2130841379);
        this.i.setContentDescription("切换播放模式 当前为随机播放");
        return;
      }
      this.i.setImageResource(2130841376);
      this.i.setContentDescription("切换播放模式 当前为顺序播放");
      return;
    }
    this.i.setImageResource(2130841380);
    this.i.setContentDescription("切换播放模式 当前为单曲循环");
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.w != null)
      {
        Drawable localDrawable = ImageUtil.a(true);
        paramString = FaceDrawable.getFaceDrawable(this.w, 1, paramString, 4, localDrawable, localDrawable);
        localDrawable = paramImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != paramString) && ((localDrawable instanceof FaceDrawable))) {
          ((FaceDrawable)localDrawable).cancel();
        }
        paramImageView.setImageDrawable(paramString);
        paramImageView.setVisibility(0);
        if ((paramImageView.getBackground() != null) && ((paramImageView.getBackground() instanceof ShapeDrawable)))
        {
          paramString = paramImageView.getTag();
          if ((paramString instanceof Integer))
          {
            int i1 = ((Integer)paramString).intValue();
            ((ShapeDrawable)paramImageView.getBackground()).getPaint().setColor(i1);
          }
        }
      }
      else
      {
        paramImageView.setImageDrawable(ImageUtil.a(true));
        paramImageView.setVisibility(0);
      }
    }
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Lyric localLyric2 = LyricParseHelper.a(paramString, true);
    Lyric localLyric1 = localLyric2;
    if (localLyric2 == null) {
      localLyric1 = LyricParseHelper.a(paramString, false);
    }
    if (localLyric1 == null) {
      return;
    }
    this.n.b();
    paramLyricViewDetail.getLyricViewInternal().setHighlightCurrentLine(true);
    paramLyricViewDetail.getLyricViewInternal().setHighlightLineNumber(2);
    this.n.a(paramLyricViewDetail);
    this.n.a(localLyric1, localLyric1, null);
  }
  
  private void a(List<String> paramList, String paramString)
  {
    int i1;
    if (paramList == null) {
      i1 = 0;
    } else {
      i1 = paramList.size();
    }
    int i2 = 0;
    while (i2 < 5)
    {
      if (i2 < i1)
      {
        this.r[i2].setVisibility(0);
        a((String)paramList.get(i2), this.r[i2]);
      }
      else
      {
        this.r[i2].setVisibility(8);
        this.r[i2].setImageDrawable(null);
      }
      i2 += 1;
    }
    if (this.y.m == 1)
    {
      this.f.setClickable(true);
      this.f.setOnTouchListener(this.E);
    }
    else
    {
      this.f.setClickable(true);
      this.f.setOnTouchListener(null);
    }
    this.g.setText(paramString);
  }
  
  private boolean a()
  {
    Bundle localBundle = getArguments();
    this.x = ((ISong)localBundle.getParcelable("song"));
    this.y = ((ListenTogetherSession)localBundle.getParcelable("session"));
    this.z = localBundle.getBoolean("isAdmin");
    return (this.x != null) && (this.y != null);
  }
  
  private void b(View paramView)
  {
    this.s = ((AvatarLayout)paramView.findViewById(2131434878));
    this.s.setOnTouchListener(this.E);
    paramView = paramView.findViewById(2131434901);
    paramView.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = AIOUtils.b(28.0F, getResources());
    paramView = ImageUtil.a(true);
    if (this.y.m == 2) {
      i1 = 1;
    } else {
      i1 = 4;
    }
    Object localObject = FaceDrawable.getFaceDrawable(this.w, i1, this.y.n, 4, paramView, paramView);
    paramView = (DynamicAvatarView)this.s.findViewById(2131429335);
    paramView.setImageDrawable((Drawable)localObject);
    int i1 = AIOUtils.b(1.5F, getResources());
    paramView.setPadding(i1, i1, i1, i1);
    paramView.setBackgroundResource(2130838762);
    localObject = (ImageView)((View)this.s.getParent()).findViewById(2131434928);
    this.t = new FileBrowserMiniAIOHelper(this.w, this.y.n);
    this.t.a((View)localObject);
    this.s.a(0, paramView, false);
    this.s.setOnClickListener(this);
  }
  
  private boolean b()
  {
    return (this.z) || (this.w.getCurrentAccountUin().equalsIgnoreCase(this.y.r));
  }
  
  private void c()
  {
    this.v = ((ListenTogetherManager)this.w.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER));
    this.u = ((ListenTogetherHandler)this.w.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER));
    this.w.addObserver(this.D);
    int[] arrayOfInt = BitmapOptionUtil.a(-1315339);
    a(arrayOfInt[0], arrayOfInt[1], true);
    a(this.x);
    this.B = this.v.a(this.x.a());
    a(this.x.a(), this.y.p, this.B);
    if (this.y.m == 1) {
      this.u.a(this.y.n);
    }
    a(e(), this.y.c);
    ListenTogetherManager.a(this.w).k().b(true);
    this.A = true;
  }
  
  private void d()
  {
    int i1 = ViewUtils.getScreenWidth();
    int i2 = ViewUtils.getScreenHeight();
    if ((i2 > 0) && (i1 > 0))
    {
      i1 = i2 - i1 - ViewUtils.dip2px(312.0F);
      if (i1 < 0)
      {
        if (i1 > ViewUtils.dip2px(50.0F) * -1)
        {
          ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin = i1;
          return;
        }
        ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin = (i1 + ViewUtils.dip2px(34.0F));
      }
    }
  }
  
  private List<String> e()
  {
    int i1 = this.y.d();
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("getC2CUins status=%d msg=%s", new Object[] { Integer.valueOf(i1), this.y.c }));
    }
    ArrayList localArrayList = new ArrayList();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return localArrayList;
        }
        localArrayList.add(this.w.getCurrentAccountUin());
        localArrayList.add(this.y.n);
        return localArrayList;
      }
      localArrayList.add(this.y.n);
      return localArrayList;
    }
    localArrayList.add(this.w.getCurrentAccountUin());
    return localArrayList;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
    paramActivity.overridePendingTransition(2130772014, 2130772007);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()) && (isAdded()))
    {
      boolean bool = NetworkUtil.isNetworkAvailable(getBaseActivity());
      int i3 = paramView.getId();
      int i1 = 0;
      int i2 = 1;
      Object localObject1;
      Object localObject2;
      switch (i3)
      {
      default: 
        break;
      case 2131447678: 
        if (!bool)
        {
          QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
        }
        else
        {
          if (this.y.m == 1) {
            ListenTogetherUtils.a(this.w, getBaseActivity(), this.y.m, this.y.n);
          }
          a(this.y.m, this.y.n, "music_tab", "clk_member");
        }
        break;
      case 2131440389: 
        if (!b())
        {
          QQToast.makeText(getBaseActivity(), HardCodeUtil.a(2131904120), 1).show();
        }
        else if (!bool)
        {
          QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
        }
        else
        {
          if (this.y.p == 1)
          {
            ListenTogetherManager.a(this.w).a(this.y.m, this.y.n);
            this.y.p = 2;
            i1 = i2;
          }
          else if (this.y.p == 2)
          {
            ListenTogetherManager.a(this.w).b(this.y.m, this.y.n);
            this.y.p = 1;
            i1 = i2;
          }
          else
          {
            i1 = 0;
          }
          if (i1 != 0) {
            a(this.x.a(), this.y.p, this.B);
          }
        }
        break;
      case 2131440388: 
        if (b()) {
          if (!bool)
          {
            QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
          }
          else
          {
            i2 = this.y.j + 1;
            i1 = i2;
            if (i2 > 3) {
              i1 = 1;
            }
            ListenTogetherManager.a(this.w).f(this.y.m, this.y.n, i1);
            localObject1 = a(this.y.m);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(i1);
            ReportController.b(null, "dc00899", (String)localObject1, "", "music_tab", "clk_mode", 0, 0, "", "", ((StringBuilder)localObject2).toString(), "");
          }
        }
        break;
      case 2131440381: 
        if (b()) {
          if (!bool)
          {
            QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
          }
          else
          {
            ListenTogetherManager.a(this.w).e(this.y.m, this.y.n, 2);
            ReportController.b(null, "dc00899", a(this.y.m), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          }
        }
        break;
      case 2131440380: 
        if (b()) {
          if (!bool)
          {
            QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
          }
          else
          {
            ListenTogetherManager.a(this.w).e(this.y.m, this.y.n, 1);
            ReportController.b(null, "dc00899", a(this.y.m), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          }
        }
        break;
      case 2131439054: 
        getBaseActivity().finish();
        break;
      case 2131434878: 
        localObject1 = this.y.n;
        if (this.y.m == 1) {
          i1 = 1;
        }
        localObject2 = this.t;
        if (localObject2 != null) {
          ((FileBrowserMiniAIOHelper)localObject2).a();
        }
        localObject2 = ContactUtils.a(this.w, (String)localObject1, i1);
        MiniChatActivity.a(getBaseActivity(), i1, (String)localObject1, (String)localObject2);
        break;
      case 2131432113: 
        if (QQMusicConst.a(getBaseActivity(), "com.tencent.qqmusic"))
        {
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&source=https%3A%2F%2Fy.qq.com%2Fm%2Findex.html%3FADTAG%3DYIQITING"));
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_qqmusic");
          getBaseActivity().startActivity((Intent)localObject1);
          a(this.y.m, this.y.n, "music_tab", "clk_openmusic");
        }
        else if (!bool)
        {
          QQToast.makeText(getBaseActivity(), 1, getBaseActivity().getString(2131892333), 0).show();
        }
        else
        {
          startActivity(new Intent(getActivity(), QQBrowserActivity.class).putExtra("url", "https://y.qq.com/m/download/index.html"));
          a(this.y.m, this.y.n, "music_tab", "clk_downloadmusic");
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.w = getBaseActivity().app;
    View localView = paramLayoutInflater.inflate(2131627525, paramViewGroup, false);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!a())
    {
      getBaseActivity().finish();
    }
    else
    {
      localView.setClickable(true);
      a(localView);
      c();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.w;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.D);
    }
    localObject = this.n;
    if (localObject != null) {
      ((LyricViewController)localObject).b();
    }
    if (this.A)
    {
      localObject = this.w;
      if (localObject != null)
      {
        ListenTogetherManager.a((QQAppInterface)localObject).k().c(false);
        this.A = false;
      }
    }
    localObject = this.t;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).d();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(2130772007, 2130772018);
    if (this.A)
    {
      ListenTogetherManager.a(this.w).k().c(false);
      this.A = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    FileBrowserMiniAIOHelper localFileBrowserMiniAIOHelper = this.t;
    if (localFileBrowserMiniAIOHelper != null) {
      localFileBrowserMiniAIOHelper.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool2 = QQMusicConst.a(getBaseActivity());
    boolean bool1 = bool2 ^ true;
    Object localObject = this.e.getTag();
    if ((localObject instanceof Boolean)) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    if (bool1 != bool2)
    {
      int i1;
      if (bool2) {
        i1 = 2131904119;
      } else {
        i1 = 2131904121;
      }
      localObject = HardCodeUtil.a(i1);
      this.e.setText((CharSequence)localObject);
      this.e.setTag(Boolean.valueOf(bool2));
    }
    localObject = this.t;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment
 * JD-Core Version:    0.7.0.1
 */