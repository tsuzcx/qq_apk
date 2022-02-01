package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSRichTextStyleParser;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.view.IRichTextMeasureText;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public class PTSNodeRichText
  extends PTSNodeTextBase<PTSRichTextNativeView>
  implements IRichTextMeasureText
{
  private static final String TAG = "PTSNodeRichText";
  private Object richData;
  
  protected PTSNodeRichText(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private JSONArray getRichData(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    try
    {
      paramObject = new JSONArray((String)paramObject);
      return paramObject;
    }
    catch (JSONException paramObject)
    {
      label21:
      break label21;
    }
    QLog.e("PTSNodeRichText", 1, "[setAttribute], value = $value parse failed");
    return null;
  }
  
  private void setRichText()
  {
    if ((this.richData instanceof JSONArray))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      RichTextParser.parse((TextView)getView(), localSpannableStringBuilder, this.richData);
      ((PTSRichTextNativeView)getView()).setText(localSpannableStringBuilder);
      ((PTSRichTextNativeView)getView()).setTruncateAttr(RichTextParser.getTruncate());
    }
  }
  
  public float[] getRichTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      paramString1 = new SpannableStringBuilder();
      this.richData = getRichData(paramString7);
      PTSRichTextStyleParser.a(this.richData, paramString1);
      float f2 = Float.parseFloat(paramString2);
      float f1 = Float.parseFloat(paramString3);
      int i = Integer.parseInt(paramString4);
      f2 = Math.max(f2, PTSRichTextStyleParser.b());
      f1 = Math.max(f1, PTSRichTextStyleParser.a());
      i = Math.max(i, PTSRichTextStyleParser.c());
      paramArrayOfFloat = PTSNodeFactory.getTextMeasuredSize(paramArrayOfFloat, paramString1.toString(), String.valueOf(f2), String.valueOf(f1), String.valueOf(i), paramString5);
      return paramArrayOfFloat;
    }
    catch (Exception paramArrayOfFloat)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[getRichTextMeasuredSize], e = ");
      paramString1.append(paramArrayOfFloat);
      QLog.e("PTSNodeRichText", 1, paramString1.toString());
    }
    return new float[0];
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setRichText();
  }
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if ("nodes".equals(paramString)) {
      this.richData = getRichData(paramObject);
    }
    return super.setAttribute(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRichText
 * JD-Core Version:    0.7.0.1
 */