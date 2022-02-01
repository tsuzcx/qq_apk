package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import java.util.List;

public class ClassicEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  public static final int INIT_PAGE = 9;
  private static final String LOG_TAG = "ClassicEmoticonPanelViewBinder";
  private static final int NUM_COLUMN = 7;
  private static final int NUM_ROW = 3;
  private int[] SYS_EMOTION_ORDER;
  private EmoticonLinearLayout.EmoticonAdapter adapter;
  private EmoticonCallback callback;
  private List<EmoticonInfo> panelData = null;
  
  public ClassicEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 7, paramInt);
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
    return getSystemPageCount() + SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT;
  }
  
  public int getSystemPageCount()
  {
    return SystemAndEmojiEmoticonInfo.getPageCount(this.SYS_EMOTION_ORDER);
  }
  
  protected void updatePanelView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    int i = getEmoticonPanelViewType(paramInt);
    if (paramInt >= getPanelPageCount()) {
      return;
    }
    if (this.panelData == null) {
      this.panelData = SystemAndEmojiEmoticonInfo.getOldEmoticonList(this.SYS_EMOTION_ORDER);
    }
    if (i == 2007)
    {
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
      this.adapter.setRowColumnNum(3, 7);
      this.adapter.setPage(paramInt);
      this.adapter.setList(this.panelData);
      this.adapter.notifyDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */