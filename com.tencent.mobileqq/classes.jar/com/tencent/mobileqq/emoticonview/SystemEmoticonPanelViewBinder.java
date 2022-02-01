package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import java.util.List;

public class SystemEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final int NUM_COLUMN = 7;
  private static final int NUM_ROW = 3;
  protected int[] SYS_EMOTION_ORDER;
  protected EmoticonLinearLayout.EmoticonAdapter adapter;
  private EmoticonCallback callback;
  private List<EmoticonInfo> panelData;
  
  public SystemEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.callback = paramEmoticonCallback;
    this.SYS_EMOTION_ORDER = SystemEmoticonInfo.getSysEmotionOrder();
  }
  
  public void destroy()
  {
    super.destroy();
    this.callback = null;
  }
  
  protected int getEmoticonPanelViewType(int paramInt)
  {
    return 2007;
  }
  
  public int getPanelPageCount()
  {
    return SystemAndEmojiEmoticonInfo.getPageCount(this.SYS_EMOTION_ORDER);
  }
  
  protected void setRowColumnNum()
  {
    if (this.adapter != null) {
      this.adapter.setRowColumnNum(3, 7);
    }
  }
  
  protected void updatePanelView(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((getEmoticonPanelViewType(paramInt) != 2007) || (paramInt >= getPanelPageCount())) {
      return;
    }
    if (this.panelData == null) {
      this.panelData = SystemEmoticonInfo.getEmoticonList(this.SYS_EMOTION_ORDER);
    }
    if (this.adapter == null)
    {
      this.adapter = new EmoticonPanelViewBinder.DefaultEmoticonAdapter(this, 2007);
      this.adapter.setHasDeleteBtn(true);
      this.adapter.setHasPlusButton(false);
      this.adapter.setHasSettingButton(false);
      EmoticonInfo localEmoticonInfo = new EmoticonInfo();
      localEmoticonInfo.action = "delete";
      this.adapter.setSpecEmoticon(localEmoticonInfo);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.callback);
    paramView.setAdapter(this.adapter);
    setRowColumnNum();
    this.adapter.setPage(paramInt);
    this.adapter.setList(this.panelData);
    this.adapter.notifyDataChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */