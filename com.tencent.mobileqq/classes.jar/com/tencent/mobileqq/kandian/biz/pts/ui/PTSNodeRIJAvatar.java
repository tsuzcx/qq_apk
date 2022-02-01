package com.tencent.mobileqq.kandian.biz.pts.ui;

import com.tencent.TMG.utils.QLog;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSValueConvertUtil;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSNodeRIJAvatar;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "Lcom/tencent/mobileqq/kandian/biz/pts/ui/PTSRIJAvatarView;", "ptsAppInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "liveRingUrl", "", "liveStatusUrl", "uin", "", "onParseValueFinished", "", "setAttribute", "", "key", "value", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeRIJAvatar
  extends PTSNodeVirtual<PTSRIJAvatarView>
{
  public static final PTSNodeRIJAvatar.Companion Companion = new PTSNodeRIJAvatar.Companion(null);
  @NotNull
  public static final String TAG = "PTSNodeRIJAvatar";
  private String liveRingUrl = "";
  private String liveStatusUrl = "";
  private long uin;
  
  public PTSNodeRIJAvatar(@NotNull PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    PTSRIJAvatarView localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
    if (localPTSRIJAvatarView != null) {
      localPTSRIJAvatarView.setLiveRingUrl(this.liveRingUrl);
    }
    localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
    if (localPTSRIJAvatarView != null) {
      localPTSRIJAvatarView.setLiveStatusUrl(this.liveStatusUrl);
    }
    if (this.uin != 0L)
    {
      localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
      if (localPTSRIJAvatarView != null) {
        localPTSRIJAvatarView.setUin(this.uin);
      }
    }
  }
  
  protected boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setAttribute], key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", value = ");
    localStringBuilder.append(paramObject);
    QLog.i("PTSNodeRIJAvatar", 1, localStringBuilder.toString());
    boolean bool = super.setAttribute(paramString, paramObject);
    if (paramString != null)
    {
      int i = paramString.hashCode();
      if (i != -548677840)
      {
        if (i != 1787904951)
        {
          if ((i == 1926253682) && (paramString.equals("data-live-status-url")))
          {
            paramString = PTSValueConvertUtil.getString(paramObject);
            if (paramString == null) {
              paramString = "";
            }
            this.liveStatusUrl = paramString;
            return true;
          }
        }
        else if (paramString.equals("data-uin"))
        {
          paramString = PTSValueConvertUtil.getString(paramObject);
          if (paramString != null)
          {
            paramString = StringsKt.toLongOrNull(paramString);
            if (paramString != null)
            {
              l = paramString.longValue();
              break label161;
            }
          }
          long l = 0L;
          label161:
          this.uin = l;
          return true;
        }
      }
      else if (paramString.equals("data-live-ring-url"))
      {
        paramString = PTSValueConvertUtil.getString(paramObject);
        if (paramString == null) {
          paramString = "";
        }
        this.liveRingUrl = paramString;
        return true;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRIJAvatar
 * JD-Core Version:    0.7.0.1
 */