package com.tencent.mobileqq.colornote.smallscreen;

import afur;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqfe;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNoteSmallScreenFullToast
  extends RelativeLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private aqfe jdField_a_of_type_Aqfe;
  public boolean a;
  
  public ColorNoteSmallScreenFullToast(Context paramContext, aqfe paramaqfe)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqfe = paramaqfe;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 0;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.setTitle("Toast");
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 768;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getResources().getString(2131690756));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839262);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(afur.a(24.0F, paramContext.getResources()), afur.a(24.0F, paramContext.getResources()));
      addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView start");
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = 0;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = 0;
          this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView end");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler error : " + localIllegalArgumentException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (paramInt1 - afur.a(12.0F, getResources()));
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (paramInt2 - afur.a(5.5F, getResources()) - arrayOfInt[1]);
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.animate().alpha(1.0F).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_2
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   10: ifne +54 -> 64
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   18: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 137
    //   26: iconst_2
    //   27: ldc 225
    //   29: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 44	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 26	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   41: invokeinterface 226 3 0
    //   46: iload_2
    //   47: istore_1
    //   48: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +13 -> 64
    //   54: ldc 137
    //   56: iconst_2
    //   57: ldc 228
    //   59: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iload_2
    //   63: istore_1
    //   64: aload_0
    //   65: invokevirtual 232	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   68: checkcast 21	android/view/WindowManager$LayoutParams
    //   71: ifnull +252 -> 323
    //   74: iload_1
    //   75: ifeq +248 -> 323
    //   78: aload_0
    //   79: getfield 30	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   82: invokestatic 237	aqfh:a	(Landroid/content/Context;)Z
    //   85: istore_1
    //   86: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +56 -> 145
    //   92: ldc 137
    //   94: iconst_2
    //   95: new 160	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   102: ldc 239
    //   104: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   111: invokevirtual 242	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: ldc 137
    //   122: iconst_2
    //   123: new 160	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   130: ldc 244
    //   132: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_1
    //   136: invokevirtual 242	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   139: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: monitorexit
    //   147: iload_1
    //   148: ireturn
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 44	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 26	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   159: invokeinterface 247 3 0
    //   164: iload_2
    //   165: istore_1
    //   166: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq -105 -> 64
    //   172: ldc 137
    //   174: iconst_2
    //   175: new 160	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   182: ldc 249
    //   184: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_3
    //   188: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iload_2
    //   198: istore_1
    //   199: goto -135 -> 64
    //   202: astore_3
    //   203: aload_0
    //   204: monitorexit
    //   205: aload_3
    //   206: athrow
    //   207: astore_3
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   213: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +110 -> 326
    //   219: ldc 137
    //   221: iconst_2
    //   222: new 160	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   229: ldc 249
    //   231: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_3
    //   235: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto +82 -> 326
    //   247: astore_3
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   253: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +75 -> 331
    //   259: ldc 137
    //   261: iconst_2
    //   262: new 160	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   269: ldc 249
    //   271: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_3
    //   275: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto +47 -> 331
    //   287: astore_3
    //   288: aload_0
    //   289: iconst_0
    //   290: putfield 28	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:jdField_a_of_type_Boolean	Z
    //   293: ldc 137
    //   295: iconst_2
    //   296: new 160	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   303: ldc 249
    //   305: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iconst_0
    //   319: istore_1
    //   320: goto -256 -> 64
    //   323: goto -237 -> 86
    //   326: iconst_0
    //   327: istore_1
    //   328: goto -264 -> 64
    //   331: iconst_0
    //   332: istore_1
    //   333: goto -269 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	ColorNoteSmallScreenFullToast
    //   5	328	1	bool1	boolean
    //   1	197	2	bool2	boolean
    //   149	39	3	localIllegalStateException	java.lang.IllegalStateException
    //   202	4	3	localObject	Object
    //   207	28	3	localBadTokenException	android.view.WindowManager.BadTokenException
    //   247	28	3	localSecurityException	java.lang.SecurityException
    //   287	22	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	32	149	java/lang/IllegalStateException
    //   32	46	149	java/lang/IllegalStateException
    //   48	62	149	java/lang/IllegalStateException
    //   6	18	202	finally
    //   18	32	202	finally
    //   32	46	202	finally
    //   48	62	202	finally
    //   64	74	202	finally
    //   78	86	202	finally
    //   86	145	202	finally
    //   145	147	202	finally
    //   150	164	202	finally
    //   166	197	202	finally
    //   203	205	202	finally
    //   208	244	202	finally
    //   248	284	202	finally
    //   288	318	202	finally
    //   18	32	207	android/view/WindowManager$BadTokenException
    //   32	46	207	android/view/WindowManager$BadTokenException
    //   48	62	207	android/view/WindowManager$BadTokenException
    //   18	32	247	java/lang/SecurityException
    //   32	46	247	java/lang/SecurityException
    //   48	62	247	java/lang/SecurityException
    //   18	32	287	java/lang/Exception
    //   32	46	287	java/lang/Exception
    //   48	62	287	java/lang/Exception
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (this.jdField_a_of_type_Aqfe != null) {
        this.jdField_a_of_type_Aqfe.a();
      }
      a();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    a();
    if (paramView == this) {
      if (this.jdField_a_of_type_Aqfe != null) {
        this.jdField_a_of_type_Aqfe.c();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.jdField_a_of_type_AndroidWidgetImageView) && (this.jdField_a_of_type_Aqfe != null)) {
        this.jdField_a_of_type_Aqfe.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast
 * JD-Core Version:    0.7.0.1
 */