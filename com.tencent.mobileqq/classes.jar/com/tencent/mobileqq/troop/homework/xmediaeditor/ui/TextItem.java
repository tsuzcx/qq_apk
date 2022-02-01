package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class TextItem
  extends EditItemBase<TextItem.TextViewHolder, TextInfo>
{
  private LayoutInflater a;
  private Context d;
  
  public TextItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.d = paramContext;
    this.a = LayoutInflater.from(paramContext);
  }
  
  public TextItem.TextViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextItem.TextViewHolder(this.a.inflate(2131627886, paramViewGroup, false));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateViewHolder. vh hash=");
    localStringBuilder.append(paramViewGroup.hashCode());
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramViewGroup.b.setOnClickListener(new TextItem.1(this));
    if (this.b.getLeftRightPadding() != 0) {
      paramViewGroup.itemView.setPadding(this.b.getLeftRightPadding(), 0, this.b.getLeftRightPadding(), 0);
    }
    return paramViewGroup;
  }
  
  public String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("a");
    paramString = ((StringBuilder)localObject).toString().split("\n");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      if (Pattern.compile("^[1-9]\\d*[、,，.)）]\\d+").matcher(paramString).find()) {
        return "";
      }
      paramString = Pattern.compile("^[1-9]\\d*[、,，.)）]").matcher(paramString);
      if (paramString.find())
      {
        localObject = paramString.group();
        paramString = ((String)localObject).substring(0, ((String)localObject).length() - 1);
        localObject = ((String)localObject).substring(((String)localObject).length() - 1);
        int i = Integer.parseInt(paramString);
        paramString = new StringBuilder();
        paramString.append(i + 1);
        paramString.append((String)localObject);
        return paramString.toString();
      }
    }
    return "";
  }
  
  public void a(View paramView, TextItem.TextViewHolder paramTextViewHolder) {}
  
  public void a(TextItem.TextViewHolder paramTextViewHolder)
  {
    super.b(paramTextViewHolder);
  }
  
  public void a(TextItem.TextViewHolder paramTextViewHolder, TextInfo paramTextInfo, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text onBindViewHolder. vh hash=");
    localStringBuilder.append(paramTextViewHolder.hashCode());
    localStringBuilder.append(", mData.position:");
    localStringBuilder.append(paramTextInfo.g);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.a);
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    if (paramTextViewHolder.c != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeTextChangedListener, mData.position:");
      localStringBuilder.append(paramTextInfo.g);
      localStringBuilder.append(", text:");
      localStringBuilder.append(paramTextInfo.a);
      localStringBuilder.append(",Listener:");
      localStringBuilder.append(paramTextViewHolder.c.toString());
      QLog.i("xmediaEditor", 1, localStringBuilder.toString());
      paramTextViewHolder.b.removeTextChangedListener(paramTextViewHolder.c);
      paramTextViewHolder.c = null;
    }
    if (paramInt != 0)
    {
      paramTextViewHolder.b.setVisibility(8);
      paramTextViewHolder.a.setText(paramTextInfo.a);
      if (TextUtils.isEmpty(paramTextInfo.a))
      {
        paramTextViewHolder.itemView.setVisibility(8);
        paramTextViewHolder.a.setVisibility(8);
        return;
      }
      paramTextViewHolder.a.setVisibility(0);
      paramTextViewHolder.itemView.setVisibility(0);
      return;
    }
    paramTextViewHolder.b.setVisibility(0);
    paramTextViewHolder.a.setVisibility(8);
    paramTextViewHolder.b.setText(paramTextInfo.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mData.position:");
    localStringBuilder.append(paramTextInfo.g);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.a);
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramTextViewHolder.b.setOnFocusChangeListener(null);
    paramTextViewHolder.b.setOnKeyListener(new TextItem.2(this, paramTextViewHolder));
    paramTextViewHolder.b.setOnEditorActionListener(new TextItem.3(this, paramTextViewHolder));
    paramTextViewHolder.b.setOnFocusChangeListener(new TextItem.4(this, paramTextInfo, paramTextViewHolder));
    paramTextViewHolder.c = new TextItem.5(this, paramTextViewHolder, paramTextInfo);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("addTextChangedListener, mData.position:");
    localStringBuilder.append(paramTextInfo.g);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.a);
    localStringBuilder.append(",Listener:");
    localStringBuilder.append(paramTextViewHolder.c.toString());
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramTextViewHolder.b.addTextChangedListener(paramTextViewHolder.c);
    if (paramTextInfo.c)
    {
      paramTextViewHolder.b.setFocusable(true);
      paramTextViewHolder.b.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new TextItem.6(this, paramTextViewHolder, paramTextInfo));
    }
    else
    {
      paramTextViewHolder.b.clearFocus();
      paramTextViewHolder.b.setFocusable(false);
      paramTextViewHolder.b.setFocusableInTouchMode(false);
    }
    if (this.b.e())
    {
      if ((((TextInfo)paramTextViewHolder.f).g == 1) && (this.b.getAdapter().getItemCount() == 2))
      {
        paramTextViewHolder.b.setHint(this.b.getHint());
        return;
      }
      paramTextViewHolder.b.setHint("");
      return;
    }
    if ((((TextInfo)paramTextViewHolder.f).g == 0) && (this.b.getAdapter().getItemCount() == 1))
    {
      paramTextViewHolder.b.setHint(this.b.getHint());
      return;
    }
    paramTextViewHolder.b.setHint("");
  }
  
  public void b(TextItem.TextViewHolder paramTextViewHolder)
  {
    super.a(paramTextViewHolder);
    TextInfo localTextInfo = (TextInfo)paramTextViewHolder.f;
    if (paramTextViewHolder.c != null)
    {
      paramTextViewHolder.b.removeTextChangedListener(paramTextViewHolder.c);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewRecycled, position:");
      localStringBuilder.append(((TextInfo)paramTextViewHolder.f).g);
      localStringBuilder.append(", text:");
      localStringBuilder.append(localTextInfo.a);
      localStringBuilder.append(",Listener:");
      localStringBuilder.append(paramTextViewHolder.c.toString());
      QLog.i("xmediaEditor", 2, localStringBuilder.toString());
      paramTextViewHolder.c = null;
    }
    paramTextViewHolder.b.setOnFocusChangeListener(null);
    if (!localTextInfo.d) {
      localTextInfo.b = paramTextViewHolder.b.getSelectionStart();
    } else {
      localTextInfo.d = true;
    }
    paramTextViewHolder.b.clearFocus();
    paramTextViewHolder.b.setFocusable(false);
    paramTextViewHolder.b.setFocusableInTouchMode(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem
 * JD-Core Version:    0.7.0.1
 */