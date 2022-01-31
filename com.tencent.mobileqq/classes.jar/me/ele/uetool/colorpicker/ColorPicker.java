package me.ele.uetool.colorpicker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import me.ele.uetool.colorpicker.listener.OnColorChangedListener;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;

public class ColorPicker
{
  private AlphaPicker alphaPicker;
  private Button cancel;
  private OnColorChangedListener colorChangedListener;
  private LinearLayout colorPickerView;
  private Context context;
  private TextView curView;
  private Dialog dialog;
  private HUEPicker huePicker;
  private int initColor = 0;
  private Button ok;
  private RecyclerView presetColor;
  private PresetColorAdapter presetColorAdapter;
  private List<Integer> presetColors;
  private int selectColor;
  private TextView selectView;
  private SVPicker svPicker;
  private TextView textView;
  
  public ColorPicker(Context paramContext, int paramInt, List<Integer> paramList, OnColorChangedListener paramOnColorChangedListener)
  {
    this.colorChangedListener = paramOnColorChangedListener;
    this.initColor = paramInt;
    this.context = paramContext;
    this.presetColors = paramList;
    this.presetColorAdapter = new PresetColorAdapter(paramContext);
    makeView(paramContext);
    setView(paramInt);
    this.huePicker.setInitColor(paramInt);
    this.svPicker.setCurColor(paramInt);
    this.alphaPicker.setColor(paramInt, false);
    setPresetColors(paramList);
    makeDialog();
  }
  
  private void changeTextColor(int paramInt, TextView paramTextView)
  {
    if (Util.isColdColor(paramInt))
    {
      paramTextView.setTextColor(Color.parseColor("#ffffff"));
      return;
    }
    paramTextView.setTextColor(Color.parseColor("#000000"));
  }
  
  private void makeDialog()
  {
    this.dialog = new Dialog(this.context, JarResource.getIdByName("style", "qb_uet_Theme.Holo.Dialog.background.Translucent"));
    this.dialog.setContentView(this.colorPickerView);
  }
  
  public String colorToString(int paramInt)
  {
    return "#" + Integer.toHexString(paramInt).toUpperCase();
  }
  
  public Dialog getDialog()
  {
    return this.dialog;
  }
  
  public void makeView(Context paramContext)
  {
    this.colorPickerView = ((LinearLayout)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(JarResource.getIdByName("layout", "qb_uet_color_picker_background"), null));
  }
  
  public void setPresetColors(List<Integer> paramList)
  {
    this.presetColorAdapter.setColorList(paramList);
  }
  
  public void setView(int paramInt)
  {
    this.huePicker = ((HUEPicker)this.colorPickerView.findViewById(JarResource.getIdByName("id", "hue_picker")));
    this.svPicker = ((SVPicker)this.colorPickerView.findViewById(JarResource.getIdByName("id", "sv_picker")));
    this.alphaPicker = ((AlphaPicker)this.colorPickerView.findViewById(JarResource.getIdByName("id", "alpha_picker")));
    this.textView = ((TextView)this.colorPickerView.findViewById(JarResource.getIdByName("id", "alpha_text")));
    this.presetColor = ((RecyclerView)this.colorPickerView.findViewById(JarResource.getIdByName("id", "preset_color")));
    this.selectView = ((TextView)this.colorPickerView.findViewById(JarResource.getIdByName("id", "select_color")));
    this.curView = ((TextView)this.colorPickerView.findViewById(JarResource.getIdByName("id", "cur_color")));
    this.cancel = ((Button)this.colorPickerView.findViewById(JarResource.getIdByName("id", "cancel")));
    this.ok = ((Button)this.colorPickerView.findViewById(JarResource.getIdByName("id", "ok")));
    this.curView.setText(colorToString(paramInt));
    ((GradientDrawable)this.curView.getBackground()).setColor(paramInt);
    changeTextColor(paramInt, this.curView);
    this.huePicker.addListener(new ColorPicker.1(this));
    this.svPicker.addListener(new ColorPicker.2(this));
    this.alphaPicker.addListener(new ColorPicker.3(this));
    this.presetColorAdapter.setHuePicker(this.huePicker);
    this.presetColor.setAdapter(this.presetColorAdapter);
    this.presetColor.setLayoutManager(new GridLayoutManager(this.context, 5));
    this.ok.setOnClickListener(new ColorPicker.4(this));
    this.cancel.setOnClickListener(new ColorPicker.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.colorpicker.ColorPicker
 * JD-Core Version:    0.7.0.1
 */