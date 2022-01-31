package com.tencent.mobileqq.triton.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;

public class UserInfoButton
  implements View.OnClickListener
{
  public static final int BUTTON_TYPE_ADD_FRIEND = 5;
  public static final int BUTTON_TYPE_FEED_BACK = 3;
  public static final int BUTTON_TYPE_GAME_CLUB = 4;
  public static final int BUTTON_TYPE_OPEN_SETTING = 2;
  public static final int BUTTON_TYPE_USER_INFO = 1;
  private static final String TAG = "UserInfoButton";
  private ImageButton imageUserInfoButton;
  private Context mContext;
  private UserInfoButton.UserInfoButtonParam mParams;
  private TTEngine mTritonEngine;
  private UserInfoButton.OnClickListener onClickListener;
  private Button textUserInfoButton;
  
  public UserInfoButton(TTEngine paramTTEngine, Context paramContext, UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    this.mTritonEngine = paramTTEngine;
    this.mContext = paramContext;
    setParam(paramUserInfoButtonParam);
  }
  
  private Drawable getBackgroundDrawable(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramFloat);
    return localGradientDrawable;
  }
  
  private void setImageUserInfoButton(UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    if ((this.imageUserInfoButton == null) || (paramUserInfoButtonParam == null)) {
      return;
    }
    if ((paramUserInfoButtonParam.style == null) || (!TextUtils.isEmpty(paramUserInfoButtonParam.style.borderColor))) {}
    for (;;)
    {
      try
      {
        i = Color.parseColor(paramUserInfoButtonParam.style.borderColor);
        if (Build.VERSION.SDK_INT < 16) {
          break label140;
        }
        this.imageUserInfoButton.setBackground(getBackgroundDrawable(0, paramUserInfoButtonParam.style.borderWidth, i, paramUserInfoButtonParam.style.borderRadius));
        this.imageUserInfoButton.setPadding(paramUserInfoButtonParam.style.borderWidth, paramUserInfoButtonParam.style.borderWidth, paramUserInfoButtonParam.style.borderWidth, paramUserInfoButtonParam.style.borderWidth);
        this.imageUserInfoButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return;
      }
      catch (Throwable localThrowable)
      {
        TTLog.e("UserInfoButton", "setImageUserInfoButton strokeColor error ", localThrowable);
      }
      int i = 0;
      continue;
      label140:
      this.imageUserInfoButton.setBackgroundDrawable(getBackgroundDrawable(0, paramUserInfoButtonParam.style.borderWidth, i, paramUserInfoButtonParam.style.borderRadius));
    }
  }
  
  private void setParam(UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    this.mParams = paramUserInfoButtonParam;
    if (this.mParams != null)
    {
      if ((!"text".equals(this.mParams.type)) || (this.textUserInfoButton != null)) {
        break label73;
      }
      this.textUserInfoButton = new Button(this.mContext);
      this.textUserInfoButton.setOnClickListener(this);
    }
    label73:
    do
    {
      while (this.textUserInfoButton != null)
      {
        setTextUserInfoButton(this.mParams);
        return;
        if (("image".equals(this.mParams.type)) && (this.imageUserInfoButton == null))
        {
          this.imageUserInfoButton = new ImageButton(this.mContext);
          this.imageUserInfoButton.setOnClickListener(this);
        }
      }
    } while (this.imageUserInfoButton == null);
    setImageUserInfoButton(this.mParams);
  }
  
  /* Error */
  private void setTextUserInfoButton(UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   19: aload_1
    //   20: getfield 174	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:text	Ljava/lang/String;
    //   23: invokevirtual 178	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_0
    //   27: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   30: iconst_0
    //   31: iconst_0
    //   32: iconst_0
    //   33: iconst_0
    //   34: invokevirtual 179	android/widget/Button:setPadding	(IIII)V
    //   37: aload_1
    //   38: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   41: ifnull -27 -> 14
    //   44: aload_1
    //   45: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   48: getfield 182	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:backgroundColor	Ljava/lang/String;
    //   51: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +243 -> 297
    //   57: aload_0
    //   58: getfield 40	com/tencent/mobileqq/triton/views/UserInfoButton:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   61: invokevirtual 188	com/tencent/mobileqq/triton/engine/TTEngine:getQQEnv	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   64: aload_1
    //   65: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   68: getfield 182	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:backgroundColor	Ljava/lang/String;
    //   71: invokeinterface 191 2 0
    //   76: istore_2
    //   77: iload 4
    //   79: istore_3
    //   80: aload_1
    //   81: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   84: getfield 83	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderColor	Ljava/lang/String;
    //   87: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +23 -> 113
    //   93: aload_0
    //   94: getfield 40	com/tencent/mobileqq/triton/views/UserInfoButton:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   97: invokevirtual 188	com/tencent/mobileqq/triton/engine/TTEngine:getQQEnv	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   100: aload_1
    //   101: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   104: getfield 83	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderColor	Ljava/lang/String;
    //   107: invokeinterface 191 2 0
    //   112: istore_3
    //   113: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   116: bipush 16
    //   118: if_icmplt +202 -> 320
    //   121: aload_0
    //   122: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   125: aload_0
    //   126: iload_2
    //   127: aload_1
    //   128: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   131: getfield 103	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderWidth	I
    //   134: iload_3
    //   135: aload_1
    //   136: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   139: getfield 106	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderRadius	I
    //   142: i2f
    //   143: invokespecial 108	com/tencent/mobileqq/triton/views/UserInfoButton:getBackgroundDrawable	(IIIF)Landroid/graphics/drawable/Drawable;
    //   146: invokevirtual 192	android/widget/Button:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   149: aload_1
    //   150: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   153: getfield 195	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:color	Ljava/lang/String;
    //   156: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +36 -> 195
    //   162: ldc 196
    //   164: istore_2
    //   165: aload_0
    //   166: getfield 40	com/tencent/mobileqq/triton/views/UserInfoButton:mTritonEngine	Lcom/tencent/mobileqq/triton/engine/TTEngine;
    //   169: invokevirtual 188	com/tencent/mobileqq/triton/engine/TTEngine:getQQEnv	()Lcom/tencent/mobileqq/triton/sdk/IQQEnv;
    //   172: aload_1
    //   173: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   176: getfield 195	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:color	Ljava/lang/String;
    //   179: invokeinterface 191 2 0
    //   184: istore_3
    //   185: iload_3
    //   186: istore_2
    //   187: aload_0
    //   188: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   191: iload_2
    //   192: invokevirtual 199	android/widget/Button:setTextColor	(I)V
    //   195: ldc 201
    //   197: aload_1
    //   198: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   201: getfield 204	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:textAlign	Ljava/lang/String;
    //   204: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifeq +159 -> 366
    //   210: aload_0
    //   211: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   214: ldc 205
    //   216: invokevirtual 208	android/widget/Button:setGravity	(I)V
    //   219: aload_1
    //   220: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   223: getfield 211	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:fontSize	I
    //   226: ifle +18 -> 244
    //   229: aload_0
    //   230: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   233: aload_1
    //   234: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   237: getfield 211	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:fontSize	I
    //   240: i2f
    //   241: invokevirtual 214	android/widget/Button:setTextSize	(F)V
    //   244: aload_1
    //   245: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   248: getfield 217	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:lineHeight	I
    //   251: iflt -237 -> 14
    //   254: aload_0
    //   255: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   258: invokevirtual 221	android/widget/Button:getPaint	()Landroid/text/TextPaint;
    //   261: aconst_null
    //   262: invokevirtual 227	android/text/TextPaint:getFontMetricsInt	(Landroid/graphics/Paint$FontMetricsInt;)I
    //   265: istore_2
    //   266: aload_0
    //   267: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   270: aload_1
    //   271: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   274: getfield 217	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:lineHeight	I
    //   277: iload_2
    //   278: isub
    //   279: i2f
    //   280: fconst_1
    //   281: invokevirtual 231	android/widget/Button:setLineSpacing	(FF)V
    //   284: return
    //   285: astore 5
    //   287: ldc 21
    //   289: ldc 233
    //   291: aload 5
    //   293: invokestatic 136	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   296: pop
    //   297: iconst_0
    //   298: istore_2
    //   299: goto -222 -> 77
    //   302: astore 5
    //   304: ldc 21
    //   306: ldc 235
    //   308: aload 5
    //   310: invokestatic 136	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   313: pop
    //   314: iload 4
    //   316: istore_3
    //   317: goto -204 -> 113
    //   320: aload_0
    //   321: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   324: aload_0
    //   325: iload_2
    //   326: aload_1
    //   327: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   330: getfield 103	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderWidth	I
    //   333: iload_3
    //   334: aload_1
    //   335: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   338: getfield 106	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:borderRadius	I
    //   341: i2f
    //   342: invokespecial 108	com/tencent/mobileqq/triton/views/UserInfoButton:getBackgroundDrawable	(IIIF)Landroid/graphics/drawable/Drawable;
    //   345: invokevirtual 236	android/widget/Button:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   348: goto -199 -> 149
    //   351: astore 5
    //   353: ldc 21
    //   355: ldc 238
    //   357: aload 5
    //   359: invokestatic 136	com/tencent/mobileqq/triton/engine/TTLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   362: pop
    //   363: goto -176 -> 187
    //   366: ldc 240
    //   368: aload_1
    //   369: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   372: getfield 204	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:textAlign	Ljava/lang/String;
    //   375: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +14 -> 392
    //   381: aload_0
    //   382: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   385: iconst_1
    //   386: invokevirtual 208	android/widget/Button:setGravity	(I)V
    //   389: goto -170 -> 219
    //   392: ldc 242
    //   394: aload_1
    //   395: getfield 78	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonParam:style	Lcom/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType;
    //   398: getfield 204	com/tencent/mobileqq/triton/views/UserInfoButton$UserInfoButtonType:textAlign	Ljava/lang/String;
    //   401: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   404: ifeq -185 -> 219
    //   407: aload_0
    //   408: getfield 154	com/tencent/mobileqq/triton/views/UserInfoButton:textUserInfoButton	Landroid/widget/Button;
    //   411: ldc 243
    //   413: invokevirtual 208	android/widget/Button:setGravity	(I)V
    //   416: goto -197 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	UserInfoButton
    //   0	419	1	paramUserInfoButtonParam	UserInfoButton.UserInfoButtonParam
    //   76	250	2	i	int
    //   79	255	3	j	int
    //   1	314	4	k	int
    //   285	7	5	localThrowable1	Throwable
    //   302	7	5	localThrowable2	Throwable
    //   351	7	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	77	285	java/lang/Throwable
    //   93	113	302	java/lang/Throwable
    //   165	185	351	java/lang/Throwable
  }
  
  public void destroy()
  {
    this.mContext = null;
    this.imageUserInfoButton = null;
    this.textUserInfoButton = null;
  }
  
  public View getButton()
  {
    if (this.textUserInfoButton != null) {
      return this.textUserInfoButton;
    }
    if (this.imageUserInfoButton != null) {
      return this.imageUserInfoButton;
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (this.onClickListener != null) {
      this.onClickListener.onClick(this.mParams);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.imageUserInfoButton != null) && (paramDrawable != null)) {
      this.imageUserInfoButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setOnClickListener(UserInfoButton.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    View localView;
    if (getButton() != null)
    {
      localView = getButton();
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.UserInfoButton
 * JD-Core Version:    0.7.0.1
 */