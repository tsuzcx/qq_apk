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
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public TextItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public TextItem.TextViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextItem.TextViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561525, paramViewGroup, false));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateViewHolder. vh hash=");
    localStringBuilder.append(paramViewGroup.hashCode());
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new TextItem.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
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
    localStringBuilder.append(paramTextInfo.jdField_c_of_type_Int);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.jdField_a_of_type_JavaLangString);
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    if (paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeTextChangedListener, mData.position:");
      localStringBuilder.append(paramTextInfo.jdField_c_of_type_Int);
      localStringBuilder.append(", text:");
      localStringBuilder.append(paramTextInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",Listener:");
      localStringBuilder.append(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
      QLog.i("xmediaEditor", 1, localStringBuilder.toString());
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
      paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    if (paramInt != 0)
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTextInfo.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramTextInfo.jdField_a_of_type_JavaLangString))
      {
        paramTextViewHolder.itemView.setVisibility(8);
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTextViewHolder.itemView.setVisibility(0);
      return;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(paramTextInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mData.position:");
    localStringBuilder.append(paramTextInfo.jdField_c_of_type_Int);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.jdField_a_of_type_JavaLangString);
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new TextItem.2(this, paramTextViewHolder));
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TextItem.3(this, paramTextViewHolder));
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new TextItem.4(this, paramTextInfo, paramTextViewHolder));
    paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = new TextItem.5(this, paramTextViewHolder, paramTextInfo);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("addTextChangedListener, mData.position:");
    localStringBuilder.append(paramTextInfo.jdField_c_of_type_Int);
    localStringBuilder.append(", text:");
    localStringBuilder.append(paramTextInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",Listener:");
    localStringBuilder.append(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
    QLog.i("xmediaEditor", 1, localStringBuilder.toString());
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
    if (paramTextInfo.jdField_a_of_type_Boolean)
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new TextItem.6(this, paramTextViewHolder, paramTextInfo));
    }
    else
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a())
    {
      if ((((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
      {
        paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    if ((((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
      return;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setHint("");
  }
  
  public void b(TextItem.TextViewHolder paramTextViewHolder)
  {
    super.a(paramTextViewHolder);
    TextInfo localTextInfo = (TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase;
    if (paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewRecycled, position:");
      localStringBuilder.append(((TextInfo)paramTextViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_c_of_type_Int);
      localStringBuilder.append(", text:");
      localStringBuilder.append(localTextInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",Listener:");
      localStringBuilder.append(paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher.toString());
      QLog.i("xmediaEditor", 2, localStringBuilder.toString());
      paramTextViewHolder.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localTextInfo.jdField_c_of_type_Boolean) {
      localTextInfo.jdField_a_of_type_Int = paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    } else {
      localTextInfo.jdField_c_of_type_Boolean = true;
    }
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
    paramTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem
 * JD-Core Version:    0.7.0.1
 */