package me.ele.uetool.colorpicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import me.ele.uetool.util.JarResource;

public class PresetColorAdapter$ColorHolder
  extends RecyclerView.ViewHolder
{
  int color;
  boolean isChosen = false;
  RoundView roundView;
  
  public PresetColorAdapter$ColorHolder(PresetColorAdapter paramPresetColorAdapter, @NonNull View paramView)
  {
    super(paramView);
    this.roundView = ((RoundView)paramView.findViewById(JarResource.getIdByName("id", "round")));
    paramView.setOnClickListener(new PresetColorAdapter.ColorHolder.1(this, paramPresetColorAdapter));
  }
  
  public void setChosen(boolean paramBoolean)
  {
    this.isChosen = paramBoolean;
    this.roundView.setChosen(paramBoolean);
  }
  
  public void setColor(int paramInt)
  {
    this.color = paramInt;
    this.roundView.setBackgroundColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.colorpicker.PresetColorAdapter.ColorHolder
 * JD-Core Version:    0.7.0.1
 */