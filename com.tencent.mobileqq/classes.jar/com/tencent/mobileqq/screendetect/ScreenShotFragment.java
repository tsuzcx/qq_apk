package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gallery.view.BigImageAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ScreenShotFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int A;
  private String B;
  private ScreenShotAdapter.OnHolderItemClickListener C = new ScreenShotFragment.1(this);
  private Bitmap D;
  private RelativeLayout E;
  private ForwardBaseOption F;
  private int G;
  private BaseActivity H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private Runnable M = new ScreenShotFragment.5(this);
  protected AdapterView.OnItemClickListener a = new ScreenShotFragment.4(this);
  private ImageView b;
  private ImageView c;
  private TextView d;
  private RecyclerView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private boolean j = false;
  private QQAppInterface k;
  private ScreenShotHelper l;
  private List<RecentBaseData> m = new ArrayList();
  private ScreenShotAdapter n;
  private LinearLayoutManager o;
  private View p;
  private LinearLayout q;
  private LinearLayout r;
  private ImageView s;
  private ElasticHorScrView t;
  private GridView u;
  private DragView v;
  private Gallery w;
  private Handler x = new Handler(Looper.getMainLooper());
  private int y;
  private int z;
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    float f2;
    float f1;
    if (paramInt == 90)
    {
      f2 = paramBitmap.getHeight();
      f1 = 0.0F;
    }
    else
    {
      f2 = paramBitmap.getHeight();
      f1 = paramBitmap.getWidth();
    }
    Object localObject = new float[9];
    localMatrix.getValues((float[])localObject);
    localMatrix.postTranslate(f2 - localObject[2], f1 - localObject[5]);
    localObject = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.RGB_565);
    Paint localPaint = new Paint();
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    localCanvas.setBitmap(null);
    return localObject;
  }
  
  protected static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(paramString.substring(paramInt));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private void a(int paramInt)
  {
    Object localObject3 = (RecentBaseData)this.m.get(paramInt);
    if ((localObject3 instanceof RecentUserBaseData))
    {
      b(((RecentBaseData)localObject3).getRecentUserType());
      localObject1 = null;
      if (getBaseActivity().getIntent() != null) {
        localObject1 = getBaseActivity().getIntent();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Intent();
      }
      localObject1 = (RecentUserBaseData)localObject3;
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment handleIconItemClick");
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("uin", ((RecentUserBaseData)localObject1).getRecentUserUin());
      ((Bundle)localObject3).putString("troop_uin", ((RecentUserBaseData)localObject1).g());
      ((Bundle)localObject3).putString("uinname", ((RecentUserBaseData)localObject1).getTitleName());
      ((Bundle)localObject3).putInt("uintype", ((RecentUserBaseData)localObject1).getRecentUserType());
      ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
      ((Intent)localObject2).setData(Uri.parse(this.B));
      ((Intent)localObject2).putExtra("forward_type", 1);
      ((Intent)localObject2).putExtra("key_share_from_screen_shot", true);
      if (this.F == null) {
        this.F = ForwardOptionBuilder.a((Intent)localObject2, getBaseActivity().app, getBaseActivity());
      }
      if (((RecentUserBaseData)localObject1).getRecentUserType() == 6000)
      {
        this.F.a(ForwardAbility.ForwardAbilityType.g.intValue(), (Bundle)localObject3);
        return;
      }
      this.F.a(ForwardAbility.ForwardAbilityType.b.intValue(), (Bundle)localObject3);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleIconItemClick : position = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", data is null!");
    QLog.e("ScreenShotFragment", 2, ((StringBuilder)localObject1).toString());
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.m.addAll(this.l.a(paramActivity, paramQQAppInterface));
  }
  
  private void a(View paramView)
  {
    this.E = ((RelativeLayout)paramView.findViewById(2131445343));
    this.E.setOnClickListener(this);
    this.c = ((ImageView)paramView.findViewById(2131445346));
    this.c.setOnClickListener(this);
    this.q = ((LinearLayout)paramView.findViewById(2131445339));
    this.b = ((ImageView)paramView.findViewById(2131445344));
    this.b.setOnClickListener(this);
    if (AppSetting.e) {
      this.b.setContentDescription(HardCodeUtil.a(2131911055));
    }
    this.e = ((RecyclerView)paramView.findViewById(2131445338));
    this.d = ((TextView)paramView.findViewById(2131445753));
    this.d.setOnClickListener(this);
    this.f = ((TextView)paramView.findViewById(2131432302));
    this.f.setOnClickListener(this);
    this.g = ((TextView)paramView.findViewById(2131448574));
    Object localObject = this.g;
    int i1;
    if ((!this.I) && (!this.L)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ViewUtils.setVisible((View)localObject, i1);
    this.g.setOnClickListener(this);
    this.h = ((TextView)paramView.findViewById(2131448589));
    this.h.setOnClickListener(this);
    this.i = ((TextView)paramView.findViewById(2131448672));
    this.i.setOnClickListener(this);
    this.v = ((DragView)paramView.findViewById(2131432158));
    this.w = ((Gallery)paramView.findViewById(2131433934));
    this.r = ((LinearLayout)paramView.findViewById(2131445340));
    this.s = ((ImageView)this.p.findViewById(2131429228));
    if (AppSetting.e) {
      this.s.setContentDescription(HardCodeUtil.a(2131901576));
    }
    this.s.setOnClickListener(this);
    this.t = ((ElasticHorScrView)paramView.findViewById(2131445785));
    localObject = this.t;
    boolean bool = true;
    ((ElasticHorScrView)localObject).setMove(true);
    this.u = ((GridView)paramView.findViewById(2131434386));
    if (this.K)
    {
      this.c.setVisibility(8);
      this.v.setVisibility(0);
      this.w.setAdapter(new BigImageAdapter(Collections.singletonList(this.B)));
      this.w.setSpacing(getResources().getDimensionPixelSize(2131297535));
      this.w.setSelection(0);
      this.v.setRatioModify(true);
      this.v.setEnableDrag(false);
      localObject = this.E;
      ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), this.E.getPaddingTop(), this.E.getPaddingRight(), 0);
      if (CheckPermission.isHasStoragePermission(getBaseActivity())) {
        j();
      } else {
        CheckPermission.requestStoragePermission(this.H, 1, new ScreenShotFragment.2(this));
      }
      ((TextView)paramView.findViewById(2131445341)).setText(HardCodeUtil.a(2131892599));
    }
    if (this.L) {
      this.g.setText(HardCodeUtil.a(2131916047));
    }
    localObject = this.E;
    ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 15, this.E.getPaddingRight(), this.E.getPaddingBottom());
    this.b.setContentDescription(getString(2131917019));
    localObject = getBaseActivity();
    Uri localUri = Uri.fromFile(new File(this.B));
    TextView localTextView1 = this.i;
    TextView localTextView2 = this.h;
    if (this.g.getVisibility() == 0) {
      bool = false;
    }
    ScreenShotHelper.a((Context)localObject, localUri, localTextView1, localTextView2, bool);
    paramView.findViewById(2131434055).setVisibility(this.g.getVisibility());
    paramView.findViewById(2131434056).setVisibility(this.h.getVisibility());
    paramView.findViewById(2131434057).setVisibility(this.i.getVisibility());
    i();
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToQzone");
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(paramBaseActivity, getBaseActivity(), localBundle, null, 2);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 0, false);
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.q.setVisibility(0);
      this.r.setVisibility(8);
      return;
    }
    this.q.setVisibility(8);
    this.r.setVisibility(0);
    if (this.K) {
      ScreenShotHelper.a("0X800A9A8", "1", "");
    }
  }
  
  private void b(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1006)
        {
          if (paramInt != 3000)
          {
            if (paramInt == 6000)
            {
              ScreenShotHelper.a("0X8009FEE", 5);
              str = "3";
              break label94;
            }
          }
          else {
            ScreenShotHelper.a("0X8009FEE", 3);
          }
        }
        else {
          ScreenShotHelper.a("0X8009FEE", 4);
        }
        str = null;
      }
      else
      {
        ScreenShotHelper.a("0X8009FEE", 2);
        str = "2";
      }
    }
    else
    {
      ScreenShotHelper.a("0X8009FEE", 1);
      str = "1";
    }
    label94:
    if ((this.K) && (str != null)) {
      ScreenShotHelper.a("0X800A9A7", str, "1");
    }
  }
  
  private static void b(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ScreenShotShareFragment launchFriendPicker path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ScreenShotFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("forward_type", 1);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    ((Intent)localObject).putExtra("key_share_from_screen_shot", true);
    ((Intent)localObject).putExtra("key_share_from_screen_need_finish", true);
    ((Intent)localObject).setData(Uri.parse(paramString));
    paramActivity.startActivityForResult((Intent)localObject, 3);
  }
  
  private void b(String paramString)
  {
    int i1;
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      this.D = a(paramString);
      if (this.D == null)
      {
        QLog.e("ScreenShotFragment", 1, "run: screenBitmap == null");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("screenBitmap : width = ");
        paramString.append(this.D.getWidth());
        paramString.append(", height = ");
        paramString.append(this.D.getHeight());
        QLog.d("ScreenShotFragment", 2, paramString.toString());
      }
      if (this.D.getHeight() > 16)
      {
        if (this.D.getWidth() <= 16) {
          return;
        }
        int i2 = this.D.getHeight();
        i1 = i2;
        if (this.K)
        {
          QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change start, height is : ", Integer.valueOf(i2) });
          int i3 = this.p.getHeight();
          if ((i3 != 0) && (i2 > i3))
          {
            i1 = i3;
          }
          else
          {
            i1 = i2;
            if (getBaseActivity() != null)
            {
              i1 = i2;
              if (i2 > ScreenUtil.getInstantScreenHeight(getBaseActivity())) {
                i1 = ScreenUtil.getInstantScreenHeight(getBaseActivity());
              }
            }
          }
          QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change finish, height is : ", Integer.valueOf(i1), " rootHeight is : ", Integer.valueOf(i3) });
        }
      }
    }
    try
    {
      paramString = Bitmap.createScaledBitmap(this.D, (int)(this.D.getWidth() * 0.0625F), (int)(i1 * 0.0625F), false);
    }
    catch (OutOfMemoryError paramString)
    {
      label298:
      Object localObject;
      Canvas localCanvas;
      break label298;
    }
    QLog.e("ScreenShotFragment", 1, "create scale Bitmap error : out of memory");
    paramString = null;
    localObject = new Canvas(this.D);
    ((Canvas)localObject).drawColor(Color.parseColor("#33000000"));
    ((Canvas)localObject).setBitmap(null);
    if (this.c != null) {
      this.x.post(new ScreenShotFragment.6(this));
    }
    if (paramString == null)
    {
      QLog.e("ScreenShotFragment", 1, "run: scaledBitmap == null");
      return;
    }
    localObject = new StackBlurManager(paramString).process(4);
    if (localObject == null)
    {
      QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
      return;
    }
    localCanvas = new Canvas(paramString);
    localCanvas.drawColor(0);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
    } else {
      localCanvas.drawColor(Color.parseColor("#7F03081A"));
    }
    localCanvas.setBitmap(null);
    if (this.p != null) {
      this.x.post(new ScreenShotFragment.7(this, paramString));
    }
  }
  
  private void b(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToFriendCircle");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 1, false);
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void c(String paramString)
  {
    com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.a(this.H, paramString, 101);
  }
  
  private void g()
  {
    Object localObject = getArguments();
    this.I = ((Bundle)localObject).getBoolean("is_aio_page_with_msg", false);
    this.J = ((Bundle)localObject).getBoolean("switch_bottom_layout", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg: mHasMsg = ");
      ((StringBuilder)localObject).append(this.I);
      ((StringBuilder)localObject).append(", mSwitchLayout = ");
      ((StringBuilder)localObject).append(this.J);
      QLog.d("ScreenShotFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment bindData");
    }
    if (this.B != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.M, 100L);
    }
    this.o = new LinearLayoutManager(getBaseActivity());
    this.o.setOrientation(0);
    this.e.setLayoutManager(this.o);
    this.n = new ScreenShotAdapter(getBaseActivity(), this.k, this.e, 0);
    this.n.a(this.C);
    this.e.setAdapter(this.n);
    this.n.a(this.m);
    List localList = c()[0];
    Object localObject1 = new TextPaint();
    ((TextPaint)localObject1).setTextSize(getBaseActivity().getResources().getDimensionPixelSize(2131299838));
    localObject1 = new StaticLayout(a(a(localList), 6), (TextPaint)localObject1, this.y, Layout.Alignment.ALIGN_CENTER, 1.0F, this.z, true);
    if (Build.VERSION.SDK_INT >= 9) {
      this.t.setOverScrollMode(2);
    }
    Object localObject2 = localList.iterator();
    int i1 = 0;
    while (((Iterator)localObject2).hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility == 0) {
        i1 += 1;
      }
    }
    int i2 = this.y + 20 + 20;
    this.u.setColumnWidth(i2);
    this.u.setNumColumns(i1);
    localObject2 = this.u.getLayoutParams();
    GridView localGridView = this.u;
    localGridView.setPadding(16, localGridView.getPaddingTop(), 16, this.u.getPaddingBottom());
    ((ViewGroup.LayoutParams)localObject2).width = (i1 * i2 + 0 + 0);
    ((ViewGroup.LayoutParams)localObject2).height = (this.y + this.A + ((StaticLayout)localObject1).getHeight());
    this.u.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.u.setAdapter(new ScreenShotFragment.ActionSheetItemAdapter(getBaseActivity(), localList));
    this.u.setSelector(new ColorDrawable(0));
    this.u.setOnItemClickListener(this.a);
  }
  
  private void i()
  {
    int i1 = this.d.getVisibility();
    int i5 = 1;
    if (i1 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (this.f.getVisibility() == 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if (this.g.getVisibility() == 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if (this.h.getVisibility() == 0) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    if (this.i.getVisibility() != 0) {
      i5 = 0;
    }
    if (i1 + 0 + i2 + i3 + i4 + i5 >= 4)
    {
      this.d.setTextSize(12.0F);
      this.f.setTextSize(12.0F);
      this.g.setTextSize(12.0F);
      this.h.setTextSize(12.0F);
      this.i.setTextSize(12.0F);
    }
  }
  
  private void j()
  {
    QQToast.makeText(getBaseActivity(), 2131915871, 0).show();
    File localFile = new File(this.B);
    com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils.a(getBaseActivity(), localFile, Utils.Crc64String(localFile.getName()));
  }
  
  private void k()
  {
    if (LiuHaiUtils.b(getBaseActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
      }
      LiuHaiUtils.enableNotch(getBaseActivity());
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment#screenShotLong");
    }
    if (getBaseActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("click_long_screen_shot", true);
      getBaseActivity().setResult(-1, localIntent);
      getBaseActivity().finish();
    }
  }
  
  public Bitmap a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return null;
      }
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapManager.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
      int i1 = ((BitmapFactory.Options)localObject).outHeight;
      ((BitmapFactory.Options)localObject).inSampleSize = ((i1 - this.G) / i1);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject = BitmapManager.a(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject).copy(Bitmap.Config.RGB_565, true);
      paramString = (String)localObject;
      if (((Bitmap)localObject).getWidth() > ((Bitmap)localObject).getHeight()) {
        paramString = a((Bitmap)localObject, 90);
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
      }
    }
    return null;
  }
  
  protected String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject1 = "";
    int i1 = 0;
    while (i1 < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i1)).label;
      Object localObject2 = localObject1;
      if (str.length() > ((String)localObject1).length()) {
        localObject2 = str;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      localBaseActivity.finish();
      localBaseActivity.overridePendingTransition(0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity, because app is null!");
      }
    }
  }
  
  public void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null)
    {
      localBaseActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
      }
      localBaseActivity.overridePendingTransition(0, 0);
    }
    if (this.K) {
      ScreenShotHelper.a("0X800A9AD", "1", "");
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] c()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131889842);
    localActionSheetItem.icon = 2130840469;
    localActionSheetItem.action = 50;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getBaseActivity().getString(2131890810);
    localActionSheetItem.icon = 2130840475;
    localActionSheetItem.action = 39;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
    }
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startEdit");
    }
    if (this.B == null) {
      return;
    }
    Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.B, true, true, true, true, true, false, false, false, 2, 122, 0, false, null);
    getBaseActivity().startActivityForResult(localIntent, 1);
  }
  
  public void f()
  {
    QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startCrop");
    if (this.B == null)
    {
      QLog.e("ScreenShotFragment", 1, "crop error : mCurrentPath is null");
      return;
    }
    Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.B, true, true, true, true, true, false, false, false, 2, 133, 0, false, null);
    getBaseActivity().startActivityForResult(localIntent, 5);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(paramInt1);
      paramIntent.append(", resultCode = ");
      paramIntent.append(paramInt2);
      QLog.d("ScreenShotFragment", 2, new Object[] { "ScreenShotShareFragment onActivityResult requestCode = ", paramIntent.toString() });
    }
    if (paramInt1 == 1)
    {
      d();
      return;
    }
    if (paramInt1 == 2)
    {
      d();
      return;
    }
    if (paramInt1 == 3)
    {
      d();
      return;
    }
    if (paramInt1 == 101) {
      d();
    }
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131448672: 
      localIntent = new Intent();
      localIntent.putExtra("preResult", (String)this.i.getTag());
      ScreenShotHelper.a(getBaseActivity(), this.B, 1, localIntent);
      ScreenShotHelper.a("0X800AC93", 0);
      this.H.finish();
      break;
    case 2131448589: 
      localIntent = new Intent();
      localIntent.putExtra("preResult", (String)this.h.getTag());
      ScreenShotHelper.a(getBaseActivity(), this.B, 2, localIntent);
      ScreenShotHelper.a("0X800AC94", 0);
      this.j = true;
      break;
    case 2131448574: 
      l();
      if (this.I) {
        ScreenShotHelper.a("0X800A8BD", 0);
      }
      if (this.L) {
        ScreenShotHelper.a("0X800A9A5", "1", "");
      }
      break;
    case 2131445753: 
      a(false);
      ScreenShotHelper.a("0X8009FEF", 0);
      break;
    case 2131445344: 
    case 2131445346: 
      b();
      break;
    case 2131445343: 
      b();
      break;
    case 2131432302: 
      if (this.K)
      {
        f();
        ScreenShotHelper.a("0X800A9AA", "1", "");
      }
      else
      {
        e();
        ScreenShotHelper.a("0X8009FF4", 0);
      }
      break;
    case 2131429228: 
      a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate");
    }
    if (getBaseActivity() == null) {
      QLog.e("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate activity has gone!");
    }
    this.H = getBaseActivity();
    this.l = new ScreenShotHelper();
    this.k = getBaseActivity().app;
    if (this.k == null)
    {
      a();
      return;
    }
    a(getBaseActivity(), this.k);
    this.y = getBaseActivity().getResources().getDimensionPixelSize(2131297127);
    this.z = getBaseActivity().getResources().getDimensionPixelOffset(2131297130);
    this.A = getBaseActivity().getResources().getDimensionPixelOffset(2131297129);
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle != null)
    {
      this.B = paramBundle.getStringExtra("screen_path");
      this.K = paramBundle.getBooleanExtra("is_web_screen_long_shot", false);
      this.L = paramBundle.getBooleanExtra("is_screen_shot_from_web", false);
      if (this.K) {
        ScreenShotHelper.a("0X800A9A6", "1", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
    }
    g();
    this.p = paramLayoutInflater.inflate(2131627771, paramViewGroup, false);
    this.p.setBackgroundColor(Color.parseColor("#aa000000"));
    this.G = getBaseActivity().getResources().getDimensionPixelSize(2131299676);
    a(this.p);
    h();
    a(this.J ^ true);
    paramLayoutInflater = this.p;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
    }
    Object localObject = this.n;
    if (localObject != null) {
      ((ScreenShotAdapter)localObject).a();
    }
    if (this.M != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.M);
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.D = null;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume");
    }
    BaseActivity localBaseActivity = getBaseActivity();
    SystemBarCompact localSystemBarCompact = localBaseActivity.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      ViewCompat.setOnApplyWindowInsetsListener(localBaseActivity.getWindow().getDecorView(), new ScreenShotFragment.3(this));
      return;
    }
    k();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.j) {
      this.H.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment
 * JD-Core Version:    0.7.0.1
 */