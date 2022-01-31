package com.tencent.mobileqq.portal;

import afxp;
import afyi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.utils.ValueAnimation;

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
  public ImageSwitchAnim a;
  ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = null;
  public SaQianView a;
  public boolean a;
  public int b;
  public long b;
  BaseAnimHolder b;
  int c;
  int d;
  public int e = 2;
  public int k;
  public int l;
  public int m;
  private int n;
  
  public HongBaoPendantHolder(View paramView)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = new ImageSwitchAnimView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public RectF a(int paramInt)
  {
    float f = this.h / 4;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.f - f, this.g - f + this.k - paramInt, this.f + this.h + f, f + (this.g + this.i) + this.k - paramInt);
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
      f3 = this.m;
      b((int)(f1 * (this.l - this.m) + f3));
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
        b();
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
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559569);
    this.c = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559568));
    paramInt3 = this.h / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842532);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt3 + paramInt1 - paramInt4, 0, paramInt2, this.c, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.m = this.jdField_a_of_type_Int;
    this.l = (this.jdField_a_of_type_Int + paramInt);
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
  
  /* Error */
  public void a(boolean paramBoolean, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 174
    //   8: iconst_2
    //   9: new 176	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   16: ldc 179
    //   18: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   35: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   38: ldc 195
    //   40: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   43: fstore_3
    //   44: fload_3
    //   45: f2i
    //   46: istore 8
    //   48: aload_0
    //   49: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   52: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   55: ldc 196
    //   57: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   60: f2i
    //   61: istore 13
    //   63: aload_0
    //   64: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   67: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   70: ldc 197
    //   72: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   75: f2i
    //   76: istore 10
    //   78: aload_0
    //   79: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   82: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   85: ldc 198
    //   87: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   90: f2i
    //   91: istore 9
    //   93: aload_0
    //   94: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   97: invokevirtual 63	android/view/View:getWidth	()I
    //   100: iload 13
    //   102: isub
    //   103: iload 10
    //   105: isub
    //   106: istore 10
    //   108: aload_0
    //   109: iload 9
    //   111: putfield 200	com/tencent/mobileqq/portal/HongBaoPendantHolder:d	I
    //   114: aload_2
    //   115: astore 16
    //   117: aload_2
    //   118: ifnonnull +31 -> 149
    //   121: aload_0
    //   122: getfield 36	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   125: iconst_1
    //   126: if_icmpne +358 -> 484
    //   129: aload_0
    //   130: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   133: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   136: ldc 201
    //   138: invokestatic 207	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   141: astore 16
    //   143: aload 16
    //   145: astore_2
    //   146: aload_2
    //   147: astore 16
    //   149: aload_0
    //   150: getfield 36	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   153: iconst_1
    //   154: if_icmpne +363 -> 517
    //   157: aload_0
    //   158: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   161: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   164: ldc 208
    //   166: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   169: fstore 6
    //   171: aload 16
    //   173: invokevirtual 211	android/graphics/Bitmap:getHeight	()I
    //   176: i2f
    //   177: fload 6
    //   179: fmul
    //   180: aload 16
    //   182: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   185: i2f
    //   186: fdiv
    //   187: fstore 5
    //   189: iload 8
    //   191: i2f
    //   192: fstore 4
    //   194: aload_0
    //   195: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   198: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   201: ldc 213
    //   203: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   206: fstore 7
    //   208: aload_0
    //   209: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   212: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   215: ldc 214
    //   217: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   220: fstore_3
    //   221: fload 4
    //   223: fload 5
    //   225: fsub
    //   226: fload 7
    //   228: fsub
    //   229: fstore 7
    //   231: fload_3
    //   232: fstore 4
    //   234: fload 7
    //   236: fstore_3
    //   237: aload_0
    //   238: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   241: ifnonnull +96 -> 337
    //   244: aload_0
    //   245: new 218	com/tencent/mobileqq/portal/ImageSwitchAnim
    //   248: dup
    //   249: aload_0
    //   250: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   253: iload 13
    //   255: iload 8
    //   257: iload 10
    //   259: iload 9
    //   261: fload 4
    //   263: f2i
    //   264: fload_3
    //   265: f2i
    //   266: fload 6
    //   268: f2i
    //   269: fload 5
    //   271: f2i
    //   272: invokespecial 221	com/tencent/mobileqq/portal/ImageSwitchAnim:<init>	(Landroid/content/Context;IIIIIIII)V
    //   275: putfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   278: aload_0
    //   279: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   282: aload_0
    //   283: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   286: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   289: ldc 222
    //   291: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   294: f2i
    //   295: putfield 223	com/tencent/mobileqq/portal/ImageSwitchAnim:i	I
    //   298: aload_0
    //   299: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   302: aload_0
    //   303: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   306: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   309: ldc 224
    //   311: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   314: f2i
    //   315: putfield 227	com/tencent/mobileqq/portal/ImageSwitchAnim:j	I
    //   318: aload_0
    //   319: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   322: aload_0
    //   323: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   326: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   329: ldc 228
    //   331: invokestatic 207	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   334: invokevirtual 231	com/tencent/mobileqq/portal/ImageSwitchAnim:c	(Landroid/graphics/Bitmap;)V
    //   337: aload_0
    //   338: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   341: fload 4
    //   343: f2i
    //   344: putfield 232	com/tencent/mobileqq/portal/ImageSwitchAnim:e	I
    //   347: aload_0
    //   348: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   351: fload_3
    //   352: f2i
    //   353: putfield 233	com/tencent/mobileqq/portal/ImageSwitchAnim:f	I
    //   356: aload_0
    //   357: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   360: fload 6
    //   362: f2i
    //   363: putfield 234	com/tencent/mobileqq/portal/ImageSwitchAnim:g	I
    //   366: aload_0
    //   367: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   370: fload 5
    //   372: f2i
    //   373: putfield 235	com/tencent/mobileqq/portal/ImageSwitchAnim:h	I
    //   376: aload_0
    //   377: getfield 36	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   380: iconst_1
    //   381: if_icmpne +206 -> 587
    //   384: aload_0
    //   385: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   388: aload_0
    //   389: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   392: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   395: ldc 236
    //   397: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   400: f2i
    //   401: putfield 237	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   404: aload_0
    //   405: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   408: aload_0
    //   409: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   412: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   415: ldc 238
    //   417: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   420: f2i
    //   421: putfield 239	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   424: aload_0
    //   425: getfield 36	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_Int	I
    //   428: iconst_3
    //   429: if_icmpne +189 -> 618
    //   432: aload_0
    //   433: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   436: aload 16
    //   438: invokevirtual 241	com/tencent/mobileqq/portal/ImageSwitchAnim:a	(Landroid/graphics/Bitmap;)V
    //   441: aload_0
    //   442: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   445: invokevirtual 243	com/tencent/mobileqq/portal/ImageSwitchAnim:a	()V
    //   448: aload_0
    //   449: iload 10
    //   451: iload 9
    //   453: iload 13
    //   455: iload 8
    //   457: aload_0
    //   458: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   461: invokevirtual 244	com/tencent/mobileqq/portal/HongBaoPendantHolder:a	(IIIILandroid/view/View;)V
    //   464: iload_1
    //   465: ifeq +165 -> 630
    //   468: aload_0
    //   469: aconst_null
    //   470: putfield 246	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   473: aload_0
    //   474: invokevirtual 247	com/tencent/mobileqq/portal/HongBaoPendantHolder:a	()V
    //   477: return
    //   478: astore_2
    //   479: aload_2
    //   480: invokevirtual 250	java/lang/OutOfMemoryError:printStackTrace	()V
    //   483: return
    //   484: aload_0
    //   485: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   488: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   491: ldc 251
    //   493: invokestatic 207	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   496: astore 16
    //   498: aload 16
    //   500: astore_2
    //   501: goto -355 -> 146
    //   504: astore 16
    //   506: aload 16
    //   508: invokevirtual 250	java/lang/OutOfMemoryError:printStackTrace	()V
    //   511: aload_2
    //   512: astore 16
    //   514: goto -365 -> 149
    //   517: aload_0
    //   518: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   521: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   524: ldc 252
    //   526: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   529: fstore_3
    //   530: iload 8
    //   532: i2f
    //   533: fstore 5
    //   535: aload_0
    //   536: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   539: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   542: ldc 253
    //   544: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   547: fstore 6
    //   549: iload 13
    //   551: i2f
    //   552: fload_3
    //   553: fsub
    //   554: fconst_2
    //   555: fdiv
    //   556: fstore 4
    //   558: fload 5
    //   560: fload_3
    //   561: fsub
    //   562: fload 6
    //   564: fsub
    //   565: fstore 7
    //   567: fload_3
    //   568: fstore 5
    //   570: fload_3
    //   571: fstore 6
    //   573: fload 7
    //   575: fstore_3
    //   576: goto -339 -> 237
    //   579: astore_2
    //   580: aload_2
    //   581: invokevirtual 250	java/lang/OutOfMemoryError:printStackTrace	()V
    //   584: goto -247 -> 337
    //   587: aload_0
    //   588: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   591: iconst_0
    //   592: putfield 237	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   595: aload_0
    //   596: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   599: aload_0
    //   600: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   603: invokevirtual 194	android/view/View:getResources	()Landroid/content/res/Resources;
    //   606: ldc 254
    //   608: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   611: f2i
    //   612: putfield 239	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   615: goto -191 -> 424
    //   618: aload_0
    //   619: getfield 216	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   622: aload 16
    //   624: invokevirtual 256	com/tencent/mobileqq/portal/ImageSwitchAnim:b	(Landroid/graphics/Bitmap;)V
    //   627: goto -179 -> 448
    //   630: aload_0
    //   631: new 4	com/tencent/mobileqq/portal/BaseAnimHolder
    //   634: dup
    //   635: invokespecial 29	com/tencent/mobileqq/portal/BaseAnimHolder:<init>	()V
    //   638: putfield 246	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   646: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   649: ldc_w 257
    //   652: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   655: f2i
    //   656: putfield 259	com/tencent/mobileqq/portal/HongBaoPendantHolder:n	I
    //   659: aload_0
    //   660: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   663: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   666: ldc_w 260
    //   669: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   672: f2i
    //   673: istore 11
    //   675: aload_0
    //   676: getfield 52	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   679: invokevirtual 138	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   682: ldc_w 261
    //   685: invokevirtual 145	android/content/res/Resources:getDimension	(I)F
    //   688: f2i
    //   689: istore 12
    //   691: iload 13
    //   693: iconst_2
    //   694: idiv
    //   695: istore 13
    //   697: iload 11
    //   699: iconst_2
    //   700: idiv
    //   701: istore 14
    //   703: aload_0
    //   704: getfield 259	com/tencent/mobileqq/portal/HongBaoPendantHolder:n	I
    //   707: istore 15
    //   709: aload_0
    //   710: getfield 246	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   713: iload 13
    //   715: iload 10
    //   717: iadd
    //   718: iload 14
    //   720: isub
    //   721: iload 15
    //   723: iload 9
    //   725: iload 8
    //   727: iadd
    //   728: iadd
    //   729: iload 11
    //   731: iload 12
    //   733: aload_0
    //   734: getfield 44	com/tencent/mobileqq/portal/HongBaoPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   737: invokevirtual 128	com/tencent/mobileqq/portal/BaseAnimHolder:a	(IIIILandroid/view/View;)V
    //   740: goto -267 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	HongBaoPendantHolder
    //   0	743	1	paramBoolean	boolean
    //   0	743	2	paramBitmap	android.graphics.Bitmap
    //   43	533	3	f1	float
    //   192	365	4	f2	float
    //   187	382	5	f3	float
    //   169	403	6	f4	float
    //   206	368	7	f5	float
    //   46	682	8	i	int
    //   91	637	9	j	int
    //   76	642	10	i1	int
    //   673	57	11	i2	int
    //   689	43	12	i3	int
    //   61	657	13	i4	int
    //   701	20	14	i5	int
    //   707	22	15	i6	int
    //   115	384	16	localBitmap1	android.graphics.Bitmap
    //   504	3	16	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   512	111	16	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	44	478	java/lang/OutOfMemoryError
    //   121	143	504	java/lang/OutOfMemoryError
    //   484	498	504	java/lang/OutOfMemoryError
    //   318	337	579	java/lang/OutOfMemoryError
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool3 = super.a();
    a();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.k);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.j != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.j = this.j;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    super.c(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a(paramCanvas);; bool1 = false)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.j != 0))
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.j = this.j;
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
  
  public void b()
  {
    this.m = this.g;
    this.l = this.jdField_a_of_type_Int;
    this.e = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new afxp();
    a(1500L);
  }
  
  public void b(int paramInt)
  {
    float f1 = 1.0F * paramInt / this.d;
    float f2 = this.c - this.d;
    this.g = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.i = ((int)(f1 * f2) + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.d = paramInt;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.g = (this.i + paramInt + this.n);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(this.f + this.h / 2, this.g);
    }
  }
  
  public void c()
  {
    super.c();
    e();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_b_of_type_Float = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public void d()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.1F), new afyi(this));
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
    b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder
 * JD-Core Version:    0.7.0.1
 */