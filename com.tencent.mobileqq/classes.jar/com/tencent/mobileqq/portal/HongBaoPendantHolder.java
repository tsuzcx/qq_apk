package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class HongBaoPendantHolder
  extends BaseAnimHolder
{
  public int a;
  public long a;
  public Context a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  BaseAnimHolder jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  ImageSwitchAnim jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
  ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = null;
  public SaQianView a;
  public boolean a;
  public int b;
  public long b;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  BaseAnimHolder jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  int jdField_c_of_type_Int;
  BaseAnimHolder jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  int d;
  public int e = 2;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  private int o = 0;
  
  public HongBaoPendantHolder(View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = new ImageSwitchAnimView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public RectF a(int paramInt)
  {
    float f1 = this.l / 4;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.j - f1, this.k - f1 + this.g - paramInt, this.j + this.l + f1, f1 + (this.k + this.m) + this.g - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    float f1 = 1.0F;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    float f3;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null)
    {
      f3 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f2);
      if (f3 <= 1.0F) {}
    }
    for (;;)
    {
      f3 = this.i;
      a((int)(f1 * (this.h - this.i) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.e)
      {
      case 2: 
      default: 
        e();
        return;
      case 1: 
        this.e = 3;
        c();
        return;
      }
      this.e = 2;
      return;
      f1 = f3;
      continue;
      f1 = f2;
    }
  }
  
  public void a(int paramInt)
  {
    float f1 = 1.0F * paramInt / this.d;
    float f2 = this.jdField_c_of_type_Int - this.d;
    this.k = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.m = ((int)(f1 * f2) + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.d = paramInt;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.k = (this.m + paramInt + this.o);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298322);
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramInt + this.j + this.l / 2, this.k);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298327);
    this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298326));
    paramInt3 = this.l / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845565);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt3 + paramInt1 - paramInt4, 0, paramInt2, this.jdField_c_of_type_Int, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.i = this.jdField_a_of_type_Int;
    this.h = (this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.e = 1;
    a(paramLong);
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoPendantHolder", 2, "updatePendantLogo ,pendantLogoBitmap = " + paramBitmap + ",switchAnim = " + this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b(paramBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
      int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298306);
      int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298303);
      int n = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298304);
      int m = this.jdField_a_of_type_AndroidViewView.getWidth() - n - j;
      if (QLog.isColorLevel()) {
        QLog.d("HongBaoPendantHolder", 2, "init close Btn, mParentView.getWidth() = " + this.jdField_a_of_type_AndroidViewView.getWidth() + "closeBtnRightMargin = " + n + "closeBtnWidth = " + j + "closeBtnLeft = " + m);
      }
      n = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298305);
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845535);
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(m, n, j, k, this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      a();
      return;
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = null;
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 194
    //   8: iconst_2
    //   9: new 196	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   16: ldc 244
    //   18: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   35: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   38: ldc 245
    //   40: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   43: f2i
    //   44: istore 8
    //   46: aload_0
    //   47: getfield 246	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   50: ifnonnull +40 -> 90
    //   53: aload_0
    //   54: new 248	android/graphics/drawable/BitmapDrawable
    //   57: dup
    //   58: aload_0
    //   59: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   62: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   65: aload_0
    //   66: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   69: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: ldc 249
    //   74: invokestatic 255	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   77: getstatic 261	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   80: iconst_1
    //   81: invokevirtual 267	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   84: invokespecial 270	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   87: putfield 246	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   90: aload_0
    //   91: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   94: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   97: ldc_w 271
    //   100: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   103: f2i
    //   104: istore 13
    //   106: aload_0
    //   107: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   110: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   113: ldc_w 272
    //   116: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   119: f2i
    //   120: istore 10
    //   122: aload_0
    //   123: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   126: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   129: ldc_w 273
    //   132: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   135: f2i
    //   136: istore 9
    //   138: aload_0
    //   139: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   142: invokevirtual 82	android/view/View:getWidth	()I
    //   145: iload 13
    //   147: isub
    //   148: iload 10
    //   150: isub
    //   151: istore 10
    //   153: aload_0
    //   154: iload 9
    //   156: putfield 136	com/tencent/mobileqq/portal/HongBaoPendantHolder:d	I
    //   159: aload_2
    //   160: astore 16
    //   162: aload_2
    //   163: ifnonnull +32 -> 195
    //   166: aload_0
    //   167: getfield 45	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   170: iconst_1
    //   171: if_icmpne +367 -> 538
    //   174: aload_0
    //   175: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   178: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   181: ldc_w 274
    //   184: invokestatic 255	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   187: astore 16
    //   189: aload 16
    //   191: astore_2
    //   192: aload_2
    //   193: astore 16
    //   195: aload_0
    //   196: getfield 45	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   199: iconst_1
    //   200: if_icmpne +372 -> 572
    //   203: aload_0
    //   204: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   207: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   210: ldc_w 275
    //   213: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   216: fstore 6
    //   218: aload 16
    //   220: invokevirtual 276	android/graphics/Bitmap:getHeight	()I
    //   223: i2f
    //   224: fload 6
    //   226: fmul
    //   227: aload 16
    //   229: invokevirtual 277	android/graphics/Bitmap:getWidth	()I
    //   232: i2f
    //   233: fdiv
    //   234: fstore 5
    //   236: iload 8
    //   238: i2f
    //   239: fstore 4
    //   241: aload_0
    //   242: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   245: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   248: ldc_w 278
    //   251: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   254: fstore 7
    //   256: aload_0
    //   257: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   260: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   263: ldc_w 279
    //   266: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   269: fstore_3
    //   270: fload 4
    //   272: fload 5
    //   274: fsub
    //   275: fload 7
    //   277: fsub
    //   278: fstore 7
    //   280: fload_3
    //   281: fstore 4
    //   283: fload 7
    //   285: fstore_3
    //   286: aload_0
    //   287: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   290: ifnonnull +99 -> 389
    //   293: aload_0
    //   294: new 145	com/tencent/mobileqq/portal/ImageSwitchAnim
    //   297: dup
    //   298: aload_0
    //   299: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   302: iload 13
    //   304: iload 8
    //   306: iload 10
    //   308: iload 9
    //   310: fload 4
    //   312: f2i
    //   313: fload_3
    //   314: f2i
    //   315: fload 6
    //   317: f2i
    //   318: fload 5
    //   320: f2i
    //   321: invokespecial 282	com/tencent/mobileqq/portal/ImageSwitchAnim:<init>	(Landroid/content/Context;IIIIIIII)V
    //   324: putfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   327: aload_0
    //   328: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   331: aload_0
    //   332: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   335: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   338: ldc_w 283
    //   341: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   344: f2i
    //   345: putfield 284	com/tencent/mobileqq/portal/ImageSwitchAnim:i	I
    //   348: aload_0
    //   349: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   352: aload_0
    //   353: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   356: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   359: ldc_w 285
    //   362: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   365: f2i
    //   366: putfield 286	com/tencent/mobileqq/portal/ImageSwitchAnim:j	I
    //   369: aload_0
    //   370: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   373: aload_0
    //   374: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   377: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   380: ldc_w 287
    //   383: invokestatic 255	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   386: invokevirtual 289	com/tencent/mobileqq/portal/ImageSwitchAnim:c	(Landroid/graphics/Bitmap;)V
    //   389: aload_0
    //   390: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   393: fload 4
    //   395: f2i
    //   396: putfield 290	com/tencent/mobileqq/portal/ImageSwitchAnim:e	I
    //   399: aload_0
    //   400: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   403: fload_3
    //   404: f2i
    //   405: putfield 291	com/tencent/mobileqq/portal/ImageSwitchAnim:f	I
    //   408: aload_0
    //   409: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   412: fload 6
    //   414: f2i
    //   415: putfield 292	com/tencent/mobileqq/portal/ImageSwitchAnim:g	I
    //   418: aload_0
    //   419: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   422: fload 5
    //   424: f2i
    //   425: putfield 293	com/tencent/mobileqq/portal/ImageSwitchAnim:h	I
    //   428: aload_0
    //   429: getfield 45	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   432: iconst_1
    //   433: if_icmpne +211 -> 644
    //   436: aload_0
    //   437: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   440: aload_0
    //   441: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   444: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   447: ldc_w 294
    //   450: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   453: f2i
    //   454: putfield 295	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   457: aload_0
    //   458: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   461: aload_0
    //   462: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   465: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   468: ldc_w 296
    //   471: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   474: f2i
    //   475: putfield 297	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   478: aload_0
    //   479: getfield 45	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   482: iconst_3
    //   483: if_icmpne +193 -> 676
    //   486: aload_0
    //   487: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   490: aload 16
    //   492: invokevirtual 299	com/tencent/mobileqq/portal/ImageSwitchAnim:a	(Landroid/graphics/Bitmap;)V
    //   495: aload_0
    //   496: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   499: invokevirtual 300	com/tencent/mobileqq/portal/ImageSwitchAnim:a	()V
    //   502: aload_0
    //   503: iload 10
    //   505: iload 9
    //   507: iload 13
    //   509: iload 8
    //   511: aload_0
    //   512: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   515: invokevirtual 301	com/tencent/mobileqq/portal/HongBaoPendantHolder:a	(IIIILandroid/view/View;)V
    //   518: iload_1
    //   519: ifeq +169 -> 688
    //   522: aload_0
    //   523: aconst_null
    //   524: putfield 148	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   527: aload_0
    //   528: invokevirtual 239	com/tencent/mobileqq/portal/HongBaoPendantHolder:a	()V
    //   531: return
    //   532: astore_2
    //   533: aload_2
    //   534: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   537: return
    //   538: aload_0
    //   539: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   542: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   545: ldc_w 305
    //   548: invokestatic 255	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   551: astore 16
    //   553: aload 16
    //   555: astore_2
    //   556: goto -364 -> 192
    //   559: astore 16
    //   561: aload 16
    //   563: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   566: aload_2
    //   567: astore 16
    //   569: goto -374 -> 195
    //   572: aload_0
    //   573: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   576: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   579: ldc_w 306
    //   582: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   585: fstore_3
    //   586: iload 8
    //   588: i2f
    //   589: fstore 5
    //   591: aload_0
    //   592: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   595: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   598: ldc_w 307
    //   601: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   604: fstore 6
    //   606: iload 13
    //   608: i2f
    //   609: fload_3
    //   610: fsub
    //   611: fconst_2
    //   612: fdiv
    //   613: fstore 4
    //   615: fload 5
    //   617: fload_3
    //   618: fsub
    //   619: fload 6
    //   621: fsub
    //   622: fstore 7
    //   624: fload_3
    //   625: fstore 5
    //   627: fload_3
    //   628: fstore 6
    //   630: fload 7
    //   632: fstore_3
    //   633: goto -347 -> 286
    //   636: astore_2
    //   637: aload_2
    //   638: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   641: goto -252 -> 389
    //   644: aload_0
    //   645: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   648: aload_0
    //   649: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   652: invokevirtual 235	android/view/View:getResources	()Landroid/content/res/Resources;
    //   655: ldc_w 308
    //   658: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   661: f2i
    //   662: putfield 295	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   665: aload_0
    //   666: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   669: iconst_0
    //   670: putfield 297	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   673: goto -195 -> 478
    //   676: aload_0
    //   677: getfield 143	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   680: aload 16
    //   682: invokevirtual 217	com/tencent/mobileqq/portal/ImageSwitchAnim:b	(Landroid/graphics/Bitmap;)V
    //   685: goto -183 -> 502
    //   688: aload_0
    //   689: new 4	com/tencent/mobileqq/portal/BaseAnimHolder
    //   692: dup
    //   693: invokespecial 30	com/tencent/mobileqq/portal/BaseAnimHolder:<init>	()V
    //   696: putfield 148	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   704: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   707: ldc_w 309
    //   710: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   713: f2i
    //   714: putfield 41	com/tencent/mobileqq/portal/HongBaoPendantHolder:o	I
    //   717: aload_0
    //   718: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   721: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   724: ldc_w 310
    //   727: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   730: f2i
    //   731: istore 11
    //   733: aload_0
    //   734: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   737: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   740: ldc_w 311
    //   743: invokevirtual 162	android/content/res/Resources:getDimension	(I)F
    //   746: f2i
    //   747: istore 12
    //   749: iload 13
    //   751: iconst_2
    //   752: idiv
    //   753: istore 13
    //   755: iload 11
    //   757: iconst_2
    //   758: idiv
    //   759: istore 14
    //   761: aload_0
    //   762: getfield 41	com/tencent/mobileqq/portal/HongBaoPendantHolder:o	I
    //   765: istore 15
    //   767: aload_0
    //   768: getfield 148	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   771: aload_0
    //   772: getfield 71	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   775: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   778: ldc_w 312
    //   781: invokevirtual 175	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   784: putfield 178	com/tencent/mobileqq/portal/BaseAnimHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   787: aload_0
    //   788: getfield 148	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   791: iload 13
    //   793: iload 10
    //   795: iadd
    //   796: iload 14
    //   798: isub
    //   799: iload 15
    //   801: iload 9
    //   803: iload 8
    //   805: iadd
    //   806: iadd
    //   807: iload 11
    //   809: iload 12
    //   811: aload_0
    //   812: getfield 63	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   815: invokevirtual 168	com/tencent/mobileqq/portal/BaseAnimHolder:a	(IIIILandroid/view/View;)V
    //   818: goto -291 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	this	HongBaoPendantHolder
    //   0	821	1	paramBoolean	boolean
    //   0	821	2	paramBitmap	Bitmap
    //   269	364	3	f1	float
    //   239	375	4	f2	float
    //   234	392	5	f3	float
    //   216	413	6	f4	float
    //   254	377	7	f5	float
    //   44	762	8	j	int
    //   136	670	9	k	int
    //   120	676	10	m	int
    //   731	77	11	n	int
    //   747	63	12	i1	int
    //   104	692	13	i2	int
    //   759	40	14	i3	int
    //   765	42	15	i4	int
    //   160	394	16	localBitmap1	Bitmap
    //   559	3	16	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   567	114	16	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	90	532	java/lang/OutOfMemoryError
    //   166	189	559	java/lang/OutOfMemoryError
    //   538	553	559	java/lang/OutOfMemoryError
    //   369	389	636	java/lang/OutOfMemoryError
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool3 = super.b();
    a();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.g);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    super.c(paramCanvas);
    if (this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a(paramCanvas);; bool1 = false)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramCanvas);
      paramCanvas.restore();
      if ((this.jdField_a_of_type_Boolean) || (bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public RectF b(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder != null)
    {
      float f1 = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j - f1, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k - f1 + this.g, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + f1, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + f1 + this.g);
      if (QLog.isColorLevel()) {
        QLog.d("HongBaoPendantHolder", 2, "getCloseBtnTouchRect debug click event, span = " + f1 + ", closeBtnHolder.x = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + ", closeBtnHolder.y = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + ", closeBtnHolder.width = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + ", closeBtnHolder.height = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + ", offsetY = " + this.g + ", listViewScrollY = " + paramInt + ", closeBtnTouchRect = " + this.jdField_b_of_type_AndroidGraphicsRectF);
      }
      return this.jdField_b_of_type_AndroidGraphicsRectF;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    e();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_b_of_type_Float = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public void c()
  {
    this.i = this.k;
    this.h = this.jdField_a_of_type_Int;
    this.e = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new BounceInterpolatorX();
    a(1500L);
  }
  
  public void d()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new HongBaoPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.e = 2;
    a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder
 * JD-Core Version:    0.7.0.1
 */