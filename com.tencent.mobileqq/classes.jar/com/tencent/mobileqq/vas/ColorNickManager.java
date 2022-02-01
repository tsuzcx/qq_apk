package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorClearableEditText.SpanComparator;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class ColorNickManager
  implements Manager
{
  private static ColorNickManager.AtParagraphComparator jdField_a_of_type_ComTencentMobileqqVasColorNickManager$AtParagraphComparator = new ColorNickManager.AtParagraphComparator(null);
  public static final String a;
  public static AtomicBoolean a;
  public Handler a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new ColorNickManager.3(this);
  public ColorNickManager.ColorNickEmoticonListProvider a;
  private CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new ColorNickManager.4(this);
  private Vector<Integer> jdField_a_of_type_JavaUtilVector = new Vector();
  ConcurrentHashMap<Integer, ColorNickManager.ColorNickColor> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".CorlorNick/");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public ColorNickManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager$ColorNickEmoticonListProvider = new ColorNickManager.ColorNickEmoticonListProvider(this);
  }
  
  public static int a(List<ColorClearableEditText.Paragraph> paramList, Paint paramPaint, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      ColorClearableEditText.Paragraph localParagraph = (ColorClearableEditText.Paragraph)paramList.next();
      switch (localParagraph.c)
      {
      }
      for (;;)
      {
        break;
        int j = (int)Math.ceil(paramPaint.measureText(localParagraph.jdField_a_of_type_JavaLangString));
        paramPaint.getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), localRect);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.height());
        i += j;
        continue;
        i += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        paramRect.bottom = Math.max(paramRect.bottom, ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().height());
      }
    }
    paramRect.left = 0;
    paramRect.right = i;
    paramRect.top = 0;
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte).jdField_a_of_type_Int;
  }
  
  private ColorNickManager.ColorNickColor a(File paramFile, int paramInt)
  {
    int i = 0;
    paramFile = FileUtils.a(paramFile, -1);
    try
    {
      paramFile = new JSONObject(paramFile);
      ColorNickManager.ColorNickColor localColorNickColor = new ColorNickManager.ColorNickColor();
      paramFile = paramFile.optJSONArray("baseInfo");
      if ((paramFile != null) && (paramFile.length() > 0))
      {
        Object localObject = paramFile.getJSONObject(0);
        localColorNickColor.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type");
        if (localColorNickColor.jdField_a_of_type_Int == 5)
        {
          localObject = jdField_a_of_type_JavaLangString + paramInt + File.separator + "shaderImg.png";
          paramFile = localColorNickColor;
          if (!new File((String)localObject).exists()) {
            return paramFile;
          }
          localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a((String)localObject, null);
          return localColorNickColor;
        }
        localColorNickColor.b = ((JSONObject)localObject).optInt("orientation");
        paramFile = ((JSONObject)localObject).optJSONArray("colors");
        if ((paramFile != null) && (paramFile.length() > 0))
        {
          localColorNickColor.jdField_a_of_type_ArrayOfInt = new int[paramFile.length()];
          paramInt = 0;
          while (paramInt < paramFile.length())
          {
            String str = paramFile.getString(paramInt);
            localColorNickColor.jdField_a_of_type_ArrayOfInt[paramInt] = Color.parseColor(str);
            paramInt += 1;
          }
        }
        if ((localColorNickColor.jdField_a_of_type_Int != 1) && (localColorNickColor.jdField_a_of_type_Int != 2))
        {
          paramFile = localColorNickColor;
          if (localColorNickColor.jdField_a_of_type_Int != 3) {
            return paramFile;
          }
        }
        localObject = ((JSONObject)localObject).optJSONArray("positions");
        paramFile = localColorNickColor;
        if (localObject == null) {
          return paramFile;
        }
        paramFile = localColorNickColor;
        if (((JSONArray)localObject).length() <= 0) {
          return paramFile;
        }
        localColorNickColor.jdField_a_of_type_ArrayOfFloat = new float[((JSONArray)localObject).length()];
        paramInt = i;
        for (;;)
        {
          paramFile = localColorNickColor;
          if (paramInt >= ((JSONArray)localObject).length()) {
            break;
          }
          paramFile = ((JSONArray)localObject).getString(paramInt);
          if (TextUtils.isDigitsOnly(paramFile))
          {
            i = Integer.parseInt(paramFile);
            localColorNickColor.jdField_a_of_type_ArrayOfFloat[paramInt] = (i / 100.0F);
          }
          paramInt += 1;
        }
      }
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("ColorNick", 1, "loadGradientConfig error: ", paramFile);
      paramFile = null;
    }
  }
  
  @NotNull
  public static ColorNickManager.ColorNickNameData a(byte[] paramArrayOfByte)
  {
    Iterator localIterator = null;
    int j = 0;
    if (paramArrayOfByte == null) {
      return new ColorNickManager.ColorNickNameData(null, 0);
    }
    Object localObject;
    int i;
    for (;;)
    {
      Oidb_0x8fc.RichCardNameElem localRichCardNameElem;
      try
      {
        localObject = new Oidb_0x8fc.CommCardNameBuf();
        ((Oidb_0x8fc.CommCardNameBuf)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localIterator;
        if (!((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.has()) {
          break label208;
        }
        paramArrayOfByte = new StringBuilder();
        localIterator = ((Oidb_0x8fc.CommCardNameBuf)localObject).rpt_rich_card_name.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRichCardNameElem = (Oidb_0x8fc.RichCardNameElem)localIterator.next();
        if (!localRichCardNameElem.bytes_ctrl.has()) {
          break label173;
        }
        paramArrayOfByte.append("<").append(localRichCardNameElem.bytes_ctrl.get().toStringUtf8()).append(">");
        continue;
        localObject = paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramArrayOfByte = null;
      }
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNick", 1, localInvalidProtocolBufferMicroException1, new Object[0]);
        i = j;
        localObject = paramArrayOfByte;
      }
      return new ColorNickManager.ColorNickNameData((String)localObject, i);
      label173:
      if (localRichCardNameElem.bytes_text.has()) {
        paramArrayOfByte.append(localRichCardNameElem.bytes_text.get().toStringUtf8());
      }
    }
    paramArrayOfByte = paramArrayOfByte.toString();
    for (;;)
    {
      try
      {
        label208:
        if (!((Oidb_0x8fc.CommCardNameBuf)localObject).uint32_cool_id.has()) {
          break label238;
        }
        i = ((Oidb_0x8fc.CommCardNameBuf)localObject).uint32_cool_id.get();
        localObject = paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2) {}
      break;
      label238:
      i = 0;
    }
  }
  
  public static ColorNickManager a(QQAppInterface paramQQAppInterface)
  {
    return ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  public static CharSequence a(MessageRecord paramMessageRecord, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    Object localObject;
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label218;
      }
      String str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {
            break label211;
          }
          localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessageRecord = a((String)localObject, paramMessageRecord, 16, 5);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessageRecord);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 5, 16);
      return paramMsgSummary.strContent;
      label211:
      localObject = "";
      continue;
      label218:
      localObject = paramMsgSummary.suffix.toString();
    }
  }
  
  public static CharSequence a(String paramString, MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.getExtInfoFromExtStr(MessageConstants.i);
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break label88;
      }
      localObject2 = (MessageForReplyText)paramMessageRecord;
      if (((MessageForReplyText)localObject2).mSourceMsgInfo == null) {
        break label88;
      }
      localObject1 = ReplyedMessageSpan.a(((MessageForReplyText)localObject2).mSourceMsgInfo.mSourceMsgSenderUin, (String)localObject1);
    }
    label88:
    for (;;)
    {
      localObject1 = a(paramString, (String)localObject1, paramInt1, paramMessageRecord, paramInt2);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new QQText(paramString, paramInt2, paramInt1, paramMessageRecord);
      }
      return localObject2;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    int k = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = MessageForText.getTroopMemberInfoFromExtrJson(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        Object localObject = new ArrayList();
        int i = 0;
        AtTroopMemberInfo localAtTroopMemberInfo;
        int j;
        while (i < paramString2.size())
        {
          localAtTroopMemberInfo = (AtTroopMemberInfo)paramString2.get(i);
          if ((localAtTroopMemberInfo.startPos < 0) || (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()))
          {
            i += 1;
          }
          else
          {
            ColorNickManager.AtTroopMemberParagraph localAtTroopMemberParagraph = new ColorNickManager.AtTroopMemberParagraph(null);
            localAtTroopMemberParagraph.jdField_a_of_type_Int = localAtTroopMemberInfo.startPos;
            if (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen > paramString1.length()) {}
            for (j = paramString1.length();; j = localAtTroopMemberInfo.textLen + j)
            {
              localAtTroopMemberParagraph.b = j;
              localAtTroopMemberParagraph.jdField_a_of_type_AndroidTextSpannableString = new ColorNickText(paramString1.subSequence(localAtTroopMemberParagraph.jdField_a_of_type_Int, localAtTroopMemberParagraph.b), paramInt1).a();
              ((ArrayList)localObject).add(localAtTroopMemberParagraph);
              break;
              j = localAtTroopMemberInfo.startPos;
            }
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          paramString2 = (ColorNickManager.AtTroopMemberParagraph[])((ArrayList)localObject).toArray(new ColorNickManager.AtTroopMemberParagraph[((ArrayList)localObject).size()]);
          Arrays.sort(paramString2, jdField_a_of_type_ComTencentMobileqqVasColorNickManager$AtParagraphComparator);
          localObject = new SpannableStringBuilder();
          int m = paramString2.length;
          j = 0;
          i = k;
          if (i < m)
          {
            localAtTroopMemberInfo = paramString2[i];
            if (localAtTroopMemberInfo.jdField_a_of_type_Int >= j) {
              ((SpannableStringBuilder)localObject).append(new QQText(paramString1.subSequence(j, localAtTroopMemberInfo.b), paramInt2, paramInt1, paramMessageRecord));
            }
            for (;;)
            {
              j = localAtTroopMemberInfo.b;
              i += 1;
              break;
              ((SpannableStringBuilder)localObject).append(localAtTroopMemberInfo.jdField_a_of_type_AndroidTextSpannableString);
            }
          }
          if (j < paramString1.length()) {
            ((SpannableStringBuilder)localObject).append(new QQText(paramString1.subSequence(j, paramString1.length()), paramInt2, paramInt1, paramMessageRecord));
          }
          return localObject;
        }
      }
    }
    return new QQText(paramString1, paramInt2, paramInt1, paramMessageRecord);
  }
  
  @NotNull
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    String str2 = b(paramByteStringMicro.toByteArray());
    String str1 = str2;
    if (str2 == null) {
      str1 = paramByteStringMicro.toStringUtf8();
    }
    return str1;
  }
  
  public static String a(ColorNickColorPanelAdapter.ColorItem paramColorItem)
  {
    int j = 0;
    char[] arrayOfChar = new char[7];
    arrayOfChar[0] = '<';
    arrayOfChar[1] = '%';
    arrayOfChar[2] = ((char)(paramColorItem.b >>> 24 & 0xFF));
    arrayOfChar[3] = ((char)(paramColorItem.b >>> 16 & 0xFF));
    arrayOfChar[4] = ((char)(paramColorItem.b >>> 8 & 0xFF));
    arrayOfChar[5] = ((char)(paramColorItem.b & 0xFF));
    arrayOfChar[6] = '>';
    int i = j;
    switch (paramColorItem.jdField_a_of_type_Int)
    {
    default: 
      i = j;
    }
    while (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] == 0) {
        arrayOfChar[i] = 'Ā';
      }
      i += 1;
      continue;
      if (paramColorItem.b == 0) {
        return "";
      }
      arrayOfChar[1] = '&';
      i = j;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString)
  {
    return jdField_a_of_type_JavaLangString + paramString + File.separator + "xydata.json";
  }
  
  @NotNull
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-8"));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return "";
  }
  
  public static List<ColorClearableEditText.Paragraph> a(int paramInt1, String paramString, Paint paramPaint, ColorClearableEditText.SpanComparator paramSpanComparator, int paramInt2)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ColorClearableEditText.a((List)localObject, paramSpanComparator, new ColorNickText(paramString, paramInt2).a());
    int i = (int)Math.ceil(paramPaint.measureText("..."));
    paramString = ((ArrayList)localObject).iterator();
    paramInt2 = 0;
    if (paramString.hasNext())
    {
      paramSpanComparator = (ColorClearableEditText.Paragraph)paramString.next();
      switch (paramSpanComparator.c)
      {
      }
      for (;;)
      {
        break;
        localObject = SceneBuilder.a(paramInt1 - paramInt2, paramSpanComparator.jdField_a_of_type_JavaLangString, paramPaint);
        int j;
        if (((String)localObject).equals(paramSpanComparator.jdField_a_of_type_JavaLangString))
        {
          j = (int)Math.ceil(paramPaint.measureText(paramSpanComparator.jdField_a_of_type_JavaLangString));
          localArrayList.add(paramSpanComparator);
          paramInt2 += j;
        }
        else
        {
          paramSpanComparator.jdField_a_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(paramSpanComparator);
          return localArrayList;
          j = ((EmoticonSpan)paramSpanComparator.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
          if (j > paramInt1 - paramInt2 - i)
          {
            localArrayList.add(new ColorClearableEditText.Paragraph(1, paramSpanComparator.jdField_a_of_type_Int, paramSpanComparator.b, "...", null));
            return localArrayList;
          }
          localArrayList.add(paramSpanComparator);
          paramInt2 += j;
          continue;
          localArrayList.add(paramSpanComparator);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(TextView paramTextView, Spannable paramSpannable, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      a((QQAppInterface)localAppRuntime, paramTextView, paramSpannable, paramInt, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable)
  {
    a(paramTextView, paramSpannable, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TextView paramTextView, Spannable paramSpannable, int paramInt, boolean paramBoolean)
  {
    if (SimpleUIUtil.a()) {
      return;
    }
    paramSpannable = (ColorSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ColorSpan.class);
    if ((paramSpannable != null) && (paramSpannable.length > 0))
    {
      paramSpannable = paramSpannable[0];
      if (paramSpannable.jdField_a_of_type_Int == 2)
      {
        paramTextView.setTextColor(paramSpannable.b);
        if ((paramTextView instanceof ColorClearableEditText)) {
          ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
        }
      }
    }
    for (;;)
    {
      TroopNickNameHelper.a(paramTextView, paramTextView.getContext(), paramInt, paramBoolean);
      return;
      if ((paramTextView instanceof ColorNickTextView))
      {
        ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
        continue;
        if (paramSpannable.jdField_a_of_type_Int == 3)
        {
          paramQQAppInterface = a(paramQQAppInterface).a(paramSpannable.b);
          if (paramQQAppInterface != null)
          {
            if ((paramTextView instanceof ColorClearableEditText))
            {
              paramTextView.setTextColor(-16777216);
              ((ColorClearableEditText)paramTextView).setSpecialColor(paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_a_of_type_ArrayOfInt, paramQQAppInterface.jdField_a_of_type_ArrayOfFloat, paramQQAppInterface.b, paramQQAppInterface.jdField_a_of_type_AndroidGraphicsBitmap);
            }
            else if ((paramTextView instanceof ColorNickTextView))
            {
              paramTextView.setTextColor(-16777216);
              ((ColorNickTextView)paramTextView).setSpecialColor(paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface.jdField_a_of_type_ArrayOfInt, paramQQAppInterface.jdField_a_of_type_ArrayOfFloat, paramQQAppInterface.b, paramQQAppInterface.jdField_a_of_type_AndroidGraphicsBitmap);
              ((ColorNickTextView)paramTextView).a = false;
            }
          }
          else if ((paramTextView instanceof ColorNickTextView))
          {
            ((ColorNickTextView)paramTextView).a = true;
            continue;
            if ((paramTextView instanceof ColorClearableEditText)) {
              ((ColorClearableEditText)paramTextView).setSpecialColor(0, null, null, 0, null);
            } else if ((paramTextView instanceof ColorNickTextView)) {
              ((ColorNickTextView)paramTextView).setSpecialColor(0, null, null, 0, null);
            }
          }
        }
      }
    }
  }
  
  public static void a(DraftTextInfo paramDraftTextInfo, XEditTextEx paramXEditTextEx, String paramString1, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString2)
  {
    if ((paramDraftTextInfo != null) && (!TextUtils.isEmpty(paramDraftTextInfo.mAtInfoStr)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramDraftTextInfo = MessageForText.getTroopMemberInfoFromExtrJson(paramDraftTextInfo.mAtInfoStr);
      if (paramDraftTextInfo != null)
      {
        paramDraftTextInfo = paramDraftTextInfo.iterator();
        while (paramDraftTextInfo.hasNext())
        {
          AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)paramDraftTextInfo.next();
          if ((localAtTroopMemberInfo.startPos <= paramXEditTextEx.getEditableText().length()) && (localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1 <= paramXEditTextEx.getEditableText().length()))
          {
            SpannableString localSpannableString = AtTroopMemberSpan.a(paramQQAppInterface, paramBaseActivity, paramString2, Long.toString(localAtTroopMemberInfo.uin), paramString1.substring(localAtTroopMemberInfo.startPos + 1, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen), false, paramXEditTextEx, true);
            if (localSpannableString != null) {
              paramXEditTextEx.getEditableText().replace(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen + 1, localSpannableString);
            }
          }
        }
      }
    }
  }
  
  public static void a(SmallEmoticonInfo paramSmallEmoticonInfo, QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    if (paramSmallEmoticonInfo.emoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramSmallEmoticonInfo.emoticon.eId);
      int j = Integer.parseInt(paramSmallEmoticonInfo.emoticon.epId);
      ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(j), new ColorNickManager.1(j, i, paramEditText));
      return;
    }
    catch (NumberFormatException paramSmallEmoticonInfo)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e("ColorNick", 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  private void a(List<ColorClearableEditText.Paragraph> paramList, Paint paramPaint, ColorNickManager.ColorNickColor paramColorNickColor, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    Paint localPaint = new Paint(paramPaint);
    int i = 0;
    Rect localRect = new Rect();
    int j = 0;
    ColorClearableEditText.Paragraph localParagraph;
    while (j < paramList.size())
    {
      localParagraph = (ColorClearableEditText.Paragraph)paramList.get(j);
      switch (localParagraph.c)
      {
      default: 
        j += 1;
        break;
      case 1: 
        if (i != 0) {
          break label380;
        }
        paramPaint.getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), localRect);
        i = localRect.height();
      }
    }
    label162:
    label186:
    label201:
    label342:
    label380:
    for (;;)
    {
      int k = 0;
      if (k < localParagraph.jdField_a_of_type_JavaLangString.length())
      {
        float f5 = paramPaint.measureText(localParagraph.jdField_a_of_type_JavaLangString, k, k + 1);
        float f1;
        float f2;
        float f3;
        if (paramColorNickColor.b == 1)
        {
          f1 = paramFloat1;
          if (paramColorNickColor.b != 1) {
            break label317;
          }
          f2 = i * 0.5F + paramFloat2 - i;
          if (paramColorNickColor.b != 1) {
            break label328;
          }
          f3 = paramFloat1 + f5;
          if (paramColorNickColor.b != 1) {
            break label342;
          }
        }
        for (float f4 = i * 0.5F + paramFloat2 - i;; f4 = i)
        {
          localPaint.setShader(new LinearGradient(f1, f2, f3, f4, paramColorNickColor.jdField_a_of_type_ArrayOfInt, paramColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          paramCanvas.drawRect(paramFloat1, paramFloat2 - i, paramFloat1 + f5, paramFloat2, localPaint);
          paramFloat1 += f5;
          k += 1;
          break;
          f1 = paramFloat1 + 0.5F * f5;
          break label162;
          f2 = paramFloat2 - i;
          break label186;
          f3 = paramFloat1 + 0.5F * f5;
          break label201;
        }
      }
      break;
      paramFloat1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
      break;
      return;
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if (paramString.charAt(i) == '<')
      {
        int j = paramString.indexOf('>', i);
        if (j > 0) {
          i = j;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte).jdField_a_of_type_JavaLangString;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "downloadGradientConfig id = " + paramInt + " is downloading");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    localIVasQuickUpdateService.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    localIVasQuickUpdateService.downloadItem(27L, "groupnickitem." + paramInt, "ColorNickManager");
  }
  
  public Shader a(int paramInt1, List<ColorClearableEditText.Paragraph> paramList, float paramFloat1, float paramFloat2, Rect paramRect, Paint paramPaint, int paramInt2, int paramInt3)
  {
    ColorNickManager.ColorNickColor localColorNickColor = a(paramInt1);
    if (localColorNickColor != null) {
      switch (localColorNickColor.jdField_a_of_type_Int)
      {
      }
    }
    label90:
    label108:
    do
    {
      return null;
      float f1;
      float f2;
      if (localColorNickColor.b == 1)
      {
        f1 = paramFloat1;
        if (localColorNickColor.b != 1) {
          break label177;
        }
        f2 = paramFloat2 + paramRect.height() * 0.5F;
        if (localColorNickColor.b != 1) {
          break label184;
        }
        paramFloat1 += paramRect.width();
        if (localColorNickColor.b != 1) {
          break label200;
        }
      }
      for (paramFloat2 += paramRect.height() * 0.5F;; paramFloat2 += paramRect.height())
      {
        return new LinearGradient(f1, f2, paramFloat1, paramFloat2, localColorNickColor.jdField_a_of_type_ArrayOfInt, localColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
        f1 = paramFloat1 + paramRect.width() * 0.5F;
        break;
        f2 = paramFloat2;
        break label90;
        paramFloat1 += paramRect.width() * 0.5F;
        break label108;
      }
      localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      a(paramList, paramPaint, localColorNickColor, new Canvas((Bitmap)localObject1), paramFloat1, paramFloat2 + paramRect.height());
      return new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return new RadialGradient(paramRect.width() / 2 + paramFloat1, paramRect.height() / 2 + paramFloat2, paramRect.width() / 2, localColorNickColor.jdField_a_of_type_ArrayOfInt, localColorNickColor.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      paramRect = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(paramRect);
      localObject2 = new Paint(paramPaint);
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 < paramList.size())
      {
        localObject3 = (ColorClearableEditText.Paragraph)paramList.get(paramInt2);
        switch (((ColorClearableEditText.Paragraph)localObject3).c)
        {
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          int i = 0;
          while (i < ((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_JavaLangString.length())
          {
            paramFloat2 = paramPaint.measureText(((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_JavaLangString, i, i + 1);
            ((Paint)localObject2).setColor(localColorNickColor.jdField_a_of_type_ArrayOfInt[(paramInt1 % localColorNickColor.jdField_a_of_type_ArrayOfInt.length)]);
            ((Paint)localObject2).setStyle(Paint.Style.FILL);
            ((Canvas)localObject1).drawRect(paramFloat1, 0.0F, paramFloat1 + paramFloat2, paramInt3, (Paint)localObject2);
            i += 1;
            paramInt1 += 1;
            paramFloat1 += paramFloat2;
          }
          continue;
          paramFloat1 += ((EmoticonSpan)((ColorClearableEditText.Paragraph)localObject3).jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        }
      }
      return new BitmapShader(paramRect, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    } while (localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap == null);
    label177:
    label184:
    label200:
    paramList = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Object localObject1 = new Canvas(paramList);
    paramInt1 = localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    Object localObject2 = new Rect();
    Object localObject3 = new Rect(0, 0, paramInt1, localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    for (paramFloat1 = 0.0F; paramFloat1 < paramRect.width(); paramFloat1 += paramInt1)
    {
      ((Rect)localObject2).set((int)paramFloat1, 0, (int)(paramInt1 + paramFloat1), paramInt3);
      ((Canvas)localObject1).drawBitmap(localColorNickColor.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject3, (Rect)localObject2, paramPaint);
    }
    return new BitmapShader(paramList, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
  }
  
  public ColorNickManager.ColorNickColor a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (ColorNickManager.ColorNickColor)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    a(paramInt);
    return null;
  }
  
  void a(int paramInt)
  {
    ThreadManagerV2.excute(new ColorNickManager.2(this, paramInt), 64, null, true);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager
 * JD-Core Version:    0.7.0.1
 */