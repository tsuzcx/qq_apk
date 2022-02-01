package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorClearableEditText.SpanComparator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AtTroopMemberSpan
  extends DynamicDrawableSpan
{
  protected String a = "";
  protected int b = -4331268;
  protected Context c;
  protected Drawable d;
  private String e = "";
  private String f = "";
  private int g = -1;
  private int h = 0;
  private String i;
  private ColorClearableEditText.SpanComparator j = new ColorClearableEditText.SpanComparator();
  
  protected AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint)
  {
    super(0);
    this.e = paramString1;
    this.a = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString2, 32).b() }));
    this.h = paramInt;
    this.c = paramContext;
    a(paramPaint);
  }
  
  protected AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramPaint);
    this.i = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString3, 32).b() }));
  }
  
  protected AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt1, Paint paramPaint, String paramString3, int paramInt2)
  {
    super(0);
    this.e = paramString1;
    this.a = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString2, 32).b() }));
    this.h = paramInt1;
    this.c = paramContext;
    this.b = paramInt2;
    a(paramPaint);
    this.i = a(String.format("%s%s", new Object[] { "@", new ColorNickText(paramString3, 32).b() }));
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText)
  {
    int k;
    int m;
    int n;
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramEditText == null) {
        return null;
      }
      if (paramEditText.getPaint() != null) {
        paramEditText.getPaint().setColor(-16777216);
      }
      k = paramEditText.getWidth();
      m = paramEditText.getPaddingLeft();
      n = paramEditText.getPaddingRight();
    }
    try
    {
      paramAppRuntime = new AtTroopMemberSpan(paramContext, paramString2, paramString3, k - m - n, paramEditText.getPaint(), paramString4);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label98:
      break label98;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.a;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(new ColorNickText(paramString1.toString(), 16).a());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    return a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramEditText, paramBoolean2, false);
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k;
    int m;
    int n;
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramEditText == null) {
        return null;
      }
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
      k = paramEditText.getWidth();
      m = paramEditText.getPaddingLeft();
      n = paramEditText.getPaddingRight();
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, k - m - n, paramEditText.getPaint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label109:
      break label109;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.a;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(new ColorNickText(paramString1.toString(), 16).a());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label51:
      break label51;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.a;
    paramString1 = new StringBuilder();
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label51:
      break label51;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.a;
    paramString1 = new StringBuilder();
    paramString1.append(paramString4);
    paramString1.append(paramContext);
    paramString1.append(" ");
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(paramAppRuntime, paramString4.length(), paramString4.length() + paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  private static AtTroopMemberSpan a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, Paint paramPaint, boolean paramBoolean2)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramInt <= 0) {
        return null;
      }
      if (paramBoolean2)
      {
        if ((paramBoolean1) || (paramString2.equalsIgnoreCase("0"))) {
          break label111;
        }
        paramString1 = ContactUtils.a(paramAppRuntime, paramString1, paramString2);
        paramAppRuntime = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          paramAppRuntime = paramString1;
          if (!TextUtils.isEmpty(paramString3)) {
            break label111;
          }
        }
      }
      else
      {
        if (paramString2.equalsIgnoreCase("0")) {
          break label111;
        }
        paramString1 = ContactUtils.b(paramAppRuntime, paramString2, true);
        paramAppRuntime = paramString1;
        if (a(paramString2, paramString1, paramString3)) {
          break label111;
        }
      }
      break label114;
      label111:
      paramAppRuntime = paramString3;
      label114:
      if (TextUtils.isEmpty(paramAppRuntime)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(" memUin:");
        paramString1.append(paramString2);
        paramString1.append(" troopMemName:");
        paramString1.append(MessageRecordUtil.a(paramAppRuntime));
        paramString1.append(" isTroop:");
        paramString1.append(paramBoolean2);
        QLog.d("_At_Me_DISC", 2, paramString1.toString());
      }
      return new AtTroopMemberSpan(paramContext, paramString2, paramAppRuntime, paramInt, paramPaint);
    }
    return null;
  }
  
  public static String a(Spannable paramSpannable, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return b(paramSpannable, paramArrayList).toString();
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int m;
    for (int k = 0; k < paramCharSequence.length(); k = m + 1)
    {
      int n = paramCharSequence.codePointAt(k);
      if ((n == 20) && (k < paramCharSequence.length() - 1)) {
        paramCharSequence.delete(k, k + 2);
      }
      for (;;)
      {
        m = k - 1;
        break;
        m = k;
        if (EmotcationConstants.EMOJI_MAP.get(n, -1) < 0) {
          break;
        }
        if (n > 65535)
        {
          m = paramCharSequence.length();
          n = k + 2;
          if (m >= n)
          {
            paramCharSequence.delete(k, n);
            continue;
          }
        }
        paramCharSequence.delete(k, k + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  public static String a(ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int k = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localJSONArray.put(k, ((AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
        k += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AtTroopMemberSpan", 1, "convertAtinfo2Json fail: ", paramArrayList);
    }
    return null;
  }
  
  public static StringBuilder a(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramStringBuilder.toString())) && (!TextUtils.isEmpty(paramString2)) && (!paramBoolean))
    {
      StringBuilder localStringBuilder;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString1);
        int i1 = localJSONArray.length();
        int k = 0;
        int m = 0;
        for (;;)
        {
          localStringBuilder = paramStringBuilder;
          if (k >= i1) {
            break label305;
          }
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          try
          {
            Object localObject = localJSONArray.getJSONObject(k);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int i3 = (byte)((JSONObject)localObject).optInt("flag", 1);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            String str = ((JSONObject)localObject).optString("uin");
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int i4 = ((JSONObject)localObject).optInt("startPos", 0);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            int i2 = ((JSONObject)localObject).optInt("textLen", 0);
            paramString1 = paramStringBuilder;
            int n = m;
            if (i3 == 0)
            {
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              localObject = new StringBuilder();
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              ((StringBuilder)localObject).append("@");
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              ((StringBuilder)localObject).append(ContactUtils.a(paramQQAppInterface, paramString2, str));
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              str = ((StringBuilder)localObject).toString();
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              paramStringBuilder = paramStringBuilder.replace(i4 + m, i4 + i2 + m, str);
              paramString1 = paramStringBuilder;
              localStringBuilder = paramStringBuilder;
              n = str.length();
              n = m + (n - i2);
              paramString1 = paramStringBuilder;
            }
            k += 1;
            paramStringBuilder = paramString1;
            m = n;
          }
          catch (Exception paramQQAppInterface)
          {
            paramStringBuilder = paramString1;
          }
          catch (JSONException paramQQAppInterface) {}
        }
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_1 ", paramQQAppInterface);
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_2", paramQQAppInterface);
        return paramStringBuilder;
      }
      catch (JSONException paramQQAppInterface)
      {
        localStringBuilder = paramStringBuilder;
      }
      label305:
      return localStringBuilder;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Recv replaceAtMsgByMarkName return discUin:");
      paramQQAppInterface.append(paramString2);
      QLog.d("AtTroopMemberSpan_At_Me_DISC", 2, paramQQAppInterface.toString());
    }
    return paramStringBuilder;
  }
  
  public static void a(int paramInt, String paramString, ChatMessage paramChatMessage)
  {
    if (paramInt == 1)
    {
      paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", paramString);
      return;
    }
    if (paramInt == 3000)
    {
      paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", paramString);
      return;
    }
    if (paramInt == 10014) {
      paramChatMessage.saveExtInfoToExtStr("guild_at_info_list", paramString);
    }
  }
  
  public static void a(int paramInt, ArrayList<AtTroopMemberInfo> paramArrayList, ChatMessage paramChatMessage)
  {
    if (((paramInt == 3000) || (paramInt == 1) || (paramInt == 10014)) && (paramArrayList.size() > 0))
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int k = 0;
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(k, ((AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
          k += 1;
        }
        if (paramInt == 1)
        {
          paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", localJSONArray.toString());
          return;
        }
        if (paramInt == 3000)
        {
          paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
          return;
        }
        if (paramInt != 10014) {
          return;
        }
        paramChatMessage.saveExtInfoToExtStr("guild_at_info_list", localJSONArray.toString());
        return;
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
    else if (((paramInt == 3000) || (paramInt == 1) || (paramInt == 10014)) && (paramArrayList.size() == 0))
    {
      if (paramInt == 1)
      {
        paramChatMessage.removeExtInfoToExtStr("troop_at_info_list");
        return;
      }
      if (paramInt == 3000)
      {
        paramChatMessage.removeExtInfoToExtStr("disc_at_info_list");
        return;
      }
      if (paramInt == 10014) {
        paramChatMessage.removeExtInfoToExtStr("guild_at_info_list");
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1))) {
      return false;
    }
    return TextUtils.isEmpty(paramString3) ^ true;
  }
  
  public static Spannable b(Spannable paramSpannable, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramSpannable != null))
    {
      paramArrayList.clear();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannable);
      int i1 = localSpannableStringBuilder.length();
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramSpannable.getSpans(0, i1 - 1, AtTroopMemberSpan.class);
      if (arrayOfAtTroopMemberSpan.length == 0) {
        return localSpannableStringBuilder;
      }
      if (arrayOfAtTroopMemberSpan.length > 1) {
        Arrays.sort(arrayOfAtTroopMemberSpan, new AtTroopMemberSpan.1(paramSpannable));
      }
      int k = 0;
      for (int m = 0; k < arrayOfAtTroopMemberSpan.length; m = n)
      {
        AtTroopMemberSpan localAtTroopMemberSpan = arrayOfAtTroopMemberSpan[k];
        int i2 = paramSpannable.getSpanStart(localAtTroopMemberSpan) + m;
        int i3 = paramSpannable.getSpanEnd(localAtTroopMemberSpan) + m;
        Object localObject = localAtTroopMemberSpan.a;
        if (!TextUtils.isEmpty(localAtTroopMemberSpan.i)) {
          localObject = localAtTroopMemberSpan.i;
        }
        try
        {
          localSpannableStringBuilder.replace(i2, i3, (CharSequence)localObject);
          AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
          String str = localAtTroopMemberSpan.e;
          if (str != null)
          {
            localAtTroopMemberInfo.uin = Long.valueOf(str).longValue();
            if (localAtTroopMemberSpan.e.equalsIgnoreCase("0")) {
              localAtTroopMemberInfo.flag = 1;
            }
          }
          localAtTroopMemberInfo.startPos = ((short)i2);
          localAtTroopMemberInfo.textLen = ((short)((String)localObject).length());
          paramArrayList.add(localAtTroopMemberInfo);
          n = m + (localAtTroopMemberInfo.textLen - (i3 - i2));
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          int n;
          label254:
          break label254;
        }
        n = m;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localSpannableStringBuilder.toString());
          ((StringBuilder)localObject).append(",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d");
          QLog.e("AtTroopMemberSpan", 2, String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i1) }));
          n = m;
        }
        k += 1;
      }
      return localSpannableStringBuilder;
    }
    else
    {
      return new SpannableStringBuilder();
    }
  }
  
  private List<ColorClearableEditText.Paragraph> b(Paint paramPaint)
  {
    int k = (int)Math.ceil(paramPaint.measureText(" "));
    List localList = ColorNickManager.a(this.h - k * 2, this.a, paramPaint, this.j, 16);
    localList.add(new ColorClearableEditText.Paragraph(1, 0, 0, "  ", null));
    this.g = ColorNickManager.a(localList, paramPaint, new Rect());
    return localList;
  }
  
  public String a()
  {
    return this.e;
  }
  
  protected void a(Paint paramPaint)
  {
    if (this.d != null) {
      return;
    }
    Object localObject2 = b(paramPaint);
    Object localObject1 = paramPaint.getFontMetrics();
    float f3 = -((Paint.FontMetrics)localObject1).top;
    int k = (int)Math.ceil(((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top);
    Object localObject3 = new RectF(0.0F, ((Paint.FontMetrics)localObject1).ascent - ((Paint.FontMetrics)localObject1).top, this.g - 2, ((Paint.FontMetrics)localObject1).descent + f3);
    Bitmap localBitmap = Bitmap.createBitmap(this.g, k, Bitmap.Config.ARGB_8888);
    localObject1 = new Canvas(localBitmap);
    int m = paramPaint.getColor();
    paramPaint.setColor(this.b);
    ((Canvas)localObject1).drawRect((RectF)localObject3, paramPaint);
    paramPaint.setColor(m);
    localObject2 = ((List)localObject2).iterator();
    float f1 = 0.0F;
    label295:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorClearableEditText.Paragraph)((Iterator)localObject2).next();
      m = ((ColorClearableEditText.Paragraph)localObject3).e;
      float f2;
      if (m != 1)
      {
        if (m != 2) {
          break label295;
        }
        localObject3 = (EmoticonSpan)((ColorClearableEditText.Paragraph)localObject3).d;
        int n = ((EmoticonSpan)localObject3).getDrawable().getBounds().height();
        m = (k - n) / 2;
        n = (n + k) / 2;
        ((EmoticonSpan)localObject3).draw((Canvas)localObject1, "", 0, 0, f1, m, n, n, paramPaint);
        f2 = ((EmoticonSpan)localObject3).getDrawable().getBounds().width();
      }
      else
      {
        ((Canvas)localObject1).drawText(((ColorClearableEditText.Paragraph)localObject3).c, f1, f3, paramPaint);
        f2 = paramPaint.measureText(((ColorClearableEditText.Paragraph)localObject3).c);
      }
      f1 += f2;
    }
    ((Canvas)localObject1).save();
    ((Canvas)localObject1).restore();
    this.d = new BitmapDrawable(this.c.getResources(), localBitmap);
    this.d.setBounds(0, 0, this.g, k);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if ((paramInt2 - paramInt1 == 1) && (this.f.length() != 1) && (paramInt1 != 0)) {
      return;
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
  
  public Drawable getDrawable()
  {
    return this.d;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if ((this.d != null) && ((paramInt2 - paramInt1 != 1) || (this.f.length() == 1) || (paramInt1 == 0))) {
      return this.d.getBounds().right;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan
 * JD-Core Version:    0.7.0.1
 */