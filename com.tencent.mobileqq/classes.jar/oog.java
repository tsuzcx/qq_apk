import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class oog
  extends pfh
{
  oog(oof paramoof) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oof.a(this.a) == paramInt))
    {
      oof.a(this.a, (ArrayList)paramList);
      if ((oof.a(this.a) == null) || (oof.a(this.a) == null) || (oof.a(this.a).size() <= 0)) {
        break label200;
      }
      oof.a(this.a).a(oof.a(this.a));
      oof.a(this.a).notifyDataSetChanged();
      if (oof.a(this.a).findHeaderViewPosition(oof.a(this.a)) < 0) {
        oof.a(this.a).addHeaderView(oof.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate infos size" + oof.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate" + paramBoolean);
      }
      return;
      label200:
      oof.a(this.a).removeHeaderView(oof.a(this.a));
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oof.a(this.a) == 0))
    {
      oof.a(this.a, (ArrayList)paramList);
      if ((oof.a(this.a) != null) && (oof.a(this.a) != null) && (oof.a(this.a).size() > 0))
      {
        oof.a(this.a).a(oof.a(this.a));
        oof.a(this.a).notifyDataSetChanged();
        if (oof.a(this.a).findHeaderViewPosition(oof.a(this.a)) < 0) {
          oof.a(this.a).addHeaderView(oof.a(this.a));
        }
        paramList = paramList.iterator();
      }
      label134:
      while (paramList.hasNext())
      {
        Object localObject = (ChannelCoverInfo)paramList.next();
        if ((!TextUtils.isEmpty(((ChannelCoverInfo)localObject).mChannelJumpUrl)) && (((ChannelCoverInfo)localObject).mChannelJumpUrl.indexOf("html/topic.html") != -1)) {
          for (;;)
          {
            int i;
            try
            {
              for (;;)
              {
                localObject = new URL(((ChannelCoverInfo)localObject).mChannelJumpUrl);
                if (TextUtils.isEmpty(((URL)localObject).getQuery())) {
                  break;
                }
                localObject = ((URL)localObject).getQuery().split("[&]");
                int j = localObject.length;
                i = 0;
                if (i >= j) {
                  break;
                }
                String[] arrayOfString = localObject[i].split("[=]");
                if (arrayOfString.length <= 1) {
                  break label388;
                }
                boolean bool = "topicid".equals(arrayOfString[0]);
                if (!bool) {
                  break label388;
                }
                try
                {
                  Integer.valueOf(arrayOfString[1]).intValue();
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic and topicId = " + arrayOfString[1]);
                }
                catch (Exception localException) {}
              }
              if (!QLog.isColorLevel()) {
                break label134;
              }
              QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic and topic is illegal");
            }
            catch (MalformedURLException localMalformedURLException) {}
            if (!QLog.isColorLevel()) {
              break label134;
            }
            QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate preload topic MalformedURLException " + localMalformedURLException);
            break label134;
            oof.a(this.a).removeHeaderView(oof.a(this.a));
            break;
            i += 1;
          }
        }
      }
      label388:
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate infos size" + oof.a(this.a).size());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate" + paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (oof.a(this.a) == 56))
    {
      oof.a(this.a, (ArrayList)paramList);
      if ((oof.a(this.a) == null) || (oof.a(this.a) == null) || (oof.a(this.a).size() <= 0)) {
        break label201;
      }
      oof.a(this.a).a(oof.a(this.a));
      oof.a(this.a).notifyDataSetChanged();
      if (oof.a(this.a).findHeaderViewPosition(oof.a(this.a)) < 0) {
        oof.a(this.a).addHeaderView(oof.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate infos size" + oof.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate" + paramBoolean);
      }
      return;
      label201:
      oof.a(this.a).removeHeaderView(oof.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oog
 * JD-Core Version:    0.7.0.1
 */