package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Adapter;
import android.widget.ImageButton;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticonview.BasePanelModel;
import com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class EmoticonInfoServiceImpl
  implements IEmoticonInfoService
{
  private static final String TAG = "EmoticonInfoServiceImpl";
  
  public void addToCommonUsed(AppRuntime paramAppRuntime, Parcelable paramParcelable, int paramInt1, int paramInt2)
  {
    if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    SystemAndEmojiEmoticonInfoSender.addToCommonUsed((BaseQQAppInterface)paramAppRuntime, (BaseSessionInfo)paramParcelable, paramInt1, paramInt2);
  }
  
  public IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context paramContext, IPanelListener paramIPanelListener)
  {
    return new QQEmoticonPanelLinearLayoutHelper(paramContext, (IPanelInteractionListener)paramIPanelListener);
  }
  
  public int getAddedHeight()
  {
    return XPanelContainer.d;
  }
  
  public List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIEmoticonMainPanelApp == null) {
      return localArrayList;
    }
    paramIEmoticonMainPanelApp = (QQEmoticonMainPanelApp)paramIEmoticonMainPanelApp;
    int m = 0;
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
      i += 1;
    }
    int n = QQSysAndEmojiConfProcessor.a();
    paramIEmoticonMainPanelApp = ((CommonUsedSystemEmojiManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
    int j;
    if ((paramIEmoticonMainPanelApp != null) && (paramIEmoticonMainPanelApp.size() > 1))
    {
      i = 0;
      j = 0;
      while ((i < paramIEmoticonMainPanelApp.size()) && (j < n * paramInt))
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramIEmoticonMainPanelApp.get(i);
        int k;
        if (localSmallYellowItem.type.get() == 2) {
          k = 2;
        } else {
          k = 1;
        }
        if ((!paramBoolean) || (k != 1) || (localSmallYellowItem.id.get() <= 255))
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
          j += 1;
        }
        i += 1;
      }
      if (j < n * paramInt)
      {
        j %= paramInt;
        if (j != 0) {
          i = m;
        }
      }
    }
    else
    {
      while (i < paramInt - j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
        continue;
        QLog.e("EmoticonInfoServiceImpl", 1, "CommonlyUsedSystemEmoji IS NULL");
      }
    }
    return localArrayList;
  }
  
  public ImageButton getDeleteImageBtn(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    if ((paramPullAndFastScrollListener instanceof EmoticonMainPanel))
    {
      paramPullAndFastScrollListener = (EmoticonMainPanel)paramPullAndFastScrollListener;
      if (paramPullAndFastScrollListener.getEmoController().getPageAdapter() != null)
      {
        int i = BasePanelModel.sLastSelectedSecondTabIndex;
        List localList = paramPullAndFastScrollListener.getEmoController().getPanelDataList();
        EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = paramPullAndFastScrollListener.getEmoController().getPageAdapter();
        if ((i >= 0) && (localList != null) && (i < localList.size()))
        {
          Object localObject = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(i);
          paramPullAndFastScrollListener = (EmotionPanelListView.PullAndFastScrollListener)localObject;
          if (localObject == null)
          {
            int j = i - 1;
            paramPullAndFastScrollListener = (EmotionPanelListView.PullAndFastScrollListener)localObject;
            if (j >= 0) {
              paramPullAndFastScrollListener = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(j);
            }
          }
          localObject = paramPullAndFastScrollListener;
          if (paramPullAndFastScrollListener == null)
          {
            i += 1;
            localObject = paramPullAndFastScrollListener;
            if (i < localList.size()) {
              localObject = localEmotionPanelViewPagerAdapter.getDeleteButtonFromCache(i);
            }
          }
          return localObject;
        }
      }
    }
    return null;
  }
  
  public List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2)
  {
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("EmoticonInfoServiceImpl", 1, "getEmoticonList app = null");
      return null;
    }
    SystemEmoticonInfo.parseWhiteList(paramIEmoticonMainPanelApp.getAppRuntime(), false);
    int[] arrayOfInt = SystemEmoticonInfo.getSysEmotionOrder();
    ArrayList localArrayList = new ArrayList(arrayOfInt.length + EmojiEmoticonInfo.EMOJI_COUNT);
    if ((paramInt2 != 2) && (paramInt2 != 3))
    {
      i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
        i += 1;
      }
      paramIEmoticonMainPanelApp = ((CommonUsedSystemEmojiManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
      if ((paramIEmoticonMainPanelApp != null) && (paramIEmoticonMainPanelApp.size() > 1))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getEmoticonList commonusedsize = ");
          ((StringBuilder)localObject).append(paramIEmoticonMainPanelApp.size());
          QLog.d("EmoticonInfoServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        j = paramIEmoticonMainPanelApp.size();
        int m = paramInt1 * 3;
        i = j;
        if (j > m) {
          i = m;
        }
        j = 0;
        while (j < i)
        {
          localObject = (EmosmPb.SmallYellowItem)paramIEmoticonMainPanelApp.get(j);
          int k;
          if (((EmosmPb.SmallYellowItem)localObject).type.get() == 2) {
            k = 2;
          } else {
            k = 1;
          }
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, ((EmosmPb.SmallYellowItem)localObject).id.get(), "", true));
          j += 1;
        }
        if (i < m)
        {
          j = i % paramInt1;
          if (j != 0) {
            i = 0;
          }
        }
      }
      else
      {
        while (i < paramInt1 - j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i += 1;
          continue;
          QLog.e("EmoticonInfoServiceImpl", 1, "CommonlyUsedSystemEmoji IS NULL");
        }
      }
    }
    int i = 0;
    while (i < paramInt1)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM, false));
      i += 1;
    }
    int j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, arrayOfInt[i], "", false));
      i += 1;
    }
    j = arrayOfInt.length % paramInt1;
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    if (paramInt2 != 2)
    {
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_EMOJI, false));
        paramInt2 += 1;
      }
      paramInt2 = 0;
      while (paramInt2 < EmojiEmoticonInfo.EMOJI_COUNT)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, paramInt2, "", false));
        paramInt2 += 1;
      }
      paramInt2 = EmojiEmoticonInfo.EMOJI_COUNT % paramInt1;
      if (paramInt2 > 0)
      {
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
          paramInt1 += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return VasUpdateUtil.a(paramAppRuntime, "emoji.systemEmojiWhiteList.json", paramBoolean, null);
  }
  
  public boolean isSmallEmotionDownloadedAdapter(Adapter paramAdapter)
  {
    return paramAdapter instanceof SmallEmotionDownloadedAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */