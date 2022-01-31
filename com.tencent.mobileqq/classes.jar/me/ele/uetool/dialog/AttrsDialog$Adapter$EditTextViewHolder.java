package me.ele.uetool.dialog;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$EditTextViewHolder<T extends EditTextItem>
  extends AttrsDialog.Adapter.BaseViewHolder<T>
{
  protected TextWatcher textWatcher = new AttrsDialog.Adapter.EditTextViewHolder.1(this);
  @Nullable
  private View vColor;
  protected EditText vDetail;
  protected TextView vName;
  
  public AttrsDialog$Adapter$EditTextViewHolder(View paramView)
  {
    super(paramView);
    this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
    this.vDetail = ((EditText)paramView.findViewById(JarResource.getIdByName("id", "detail")));
    this.vColor = paramView.findViewById(JarResource.getIdByName("id", "color"));
    if (this.vColor != null) {
      this.vColor.setOnClickListener(new AttrsDialog.Adapter.EditTextViewHolder.2(this, paramView));
    }
    this.vDetail.addTextChangedListener(this.textWatcher);
    paramView.setOnClickListener(new AttrsDialog.Adapter.EditTextViewHolder.3(this));
  }
  
  public static EditTextViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new EditTextViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_edit_text"), paramViewGroup, false));
  }
  
  public void bindView(T paramT)
  {
    super.bindView(paramT);
    this.vName.setText(paramT.getName());
    this.vDetail.setText(paramT.getDetail());
    if (this.vColor != null) {}
    try
    {
      this.vColor.setBackgroundColor(Color.parseColor(paramT.getDetail()));
      this.vColor.setVisibility(0);
      return;
    }
    catch (Exception paramT)
    {
      this.vColor.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.EditTextViewHolder
 * JD-Core Version:    0.7.0.1
 */