package me.ele.uetool.dialog;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.util.JarResource;

public class AttrsDialog$Adapter$TextViewHolder
  extends AttrsDialog.Adapter.BaseViewHolder<TextItem>
{
  private TextView vDetail;
  private TextView vName;
  
  public AttrsDialog$Adapter$TextViewHolder(View paramView)
  {
    super(paramView);
    this.vName = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "name")));
    this.vDetail = ((TextView)paramView.findViewById(JarResource.getIdByName("id", "detail")));
  }
  
  public static TextViewHolder newInstance(ViewGroup paramViewGroup)
  {
    return new TextViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(JarResource.getIdByName("layout", "qb_uet_cell_text"), paramViewGroup, false));
  }
  
  public void bindView(TextItem paramTextItem)
  {
    super.bindView(paramTextItem);
    this.vName.setText(paramTextItem.getName());
    String str = paramTextItem.getDetail();
    if (paramTextItem.getOnClickListener() != null)
    {
      this.vDetail.setText(Html.fromHtml("<u>" + str + "</u>"));
      this.vDetail.setOnClickListener(paramTextItem.getOnClickListener());
    }
    do
    {
      return;
      this.vDetail.setText(str);
    } while (!paramTextItem.isEnableCopy());
    this.vDetail.setOnClickListener(new AttrsDialog.Adapter.TextViewHolder.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */