package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.DispatchKeyEventListener;

public class SystemAndEmojiUniversalPanel$Builder
{
  private Context mContext;
  private ISystemAndEmojiPanelService.DispatchKeyEventListener mDispatchKeyEventListener;
  private EditText mEditText;
  private EmoticonCallback mEmoticonCallback;
  private boolean mFilterSysFaceBeyond255Enable = false;
  private boolean mShowCommonUsedSystemEmoji = false;
  private boolean mShowDescribeInPreview = false;
  private int rowCount = 7;
  
  public SystemAndEmojiUniversalPanel$Builder(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public SystemAndEmojiUniversalPanel create(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    SystemAndEmojiUniversalPanel localSystemAndEmojiUniversalPanel = (SystemAndEmojiUniversalPanel)View.inflate(this.mContext, 2131629361, null);
    into(localSystemAndEmojiUniversalPanel, paramIEmoticonMainPanelApp);
    return localSystemAndEmojiUniversalPanel;
  }
  
  public void into(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel, IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    if (paramSystemAndEmojiUniversalPanel == null) {
      return;
    }
    paramSystemAndEmojiUniversalPanel.setEmoticonCallback(this.mEmoticonCallback);
    paramSystemAndEmojiUniversalPanel.setDispatchKeyEventListener(this.mDispatchKeyEventListener);
    paramSystemAndEmojiUniversalPanel.setShowDeleteButton(this.mEditText);
    paramSystemAndEmojiUniversalPanel.setShowCommonUsedSystemEmoji(this.mShowCommonUsedSystemEmoji);
    paramSystemAndEmojiUniversalPanel.setFilterSysFaceBeyond255Enable(this.mFilterSysFaceBeyond255Enable);
    SystemAndEmojiUniversalPanel.access$1000(paramSystemAndEmojiUniversalPanel, this.mShowDescribeInPreview);
    paramSystemAndEmojiUniversalPanel.setRowCount(this.rowCount);
    paramSystemAndEmojiUniversalPanel.init(paramIEmoticonMainPanelApp);
  }
  
  public Builder setDispatchKeyEventListener(ISystemAndEmojiPanelService.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.mDispatchKeyEventListener = paramDispatchKeyEventListener;
    return this;
  }
  
  public Builder setEmoticonCallback(EmoticonCallback paramEmoticonCallback)
  {
    this.mEmoticonCallback = paramEmoticonCallback;
    return this;
  }
  
  public Builder setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mFilterSysFaceBeyond255Enable = paramBoolean;
    return this;
  }
  
  public Builder setRowCount(int paramInt)
  {
    this.rowCount = paramInt;
    return this;
  }
  
  public Builder setShowCommonUsedSystemEmoji(boolean paramBoolean)
  {
    this.mShowCommonUsedSystemEmoji = paramBoolean;
    return this;
  }
  
  public Builder setShowDeleteButton(EditText paramEditText)
  {
    this.mEditText = paramEditText;
    return this;
  }
  
  public Builder setShowDescribeInPreview(boolean paramBoolean)
  {
    this.mShowDescribeInPreview = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder
 * JD-Core Version:    0.7.0.1
 */