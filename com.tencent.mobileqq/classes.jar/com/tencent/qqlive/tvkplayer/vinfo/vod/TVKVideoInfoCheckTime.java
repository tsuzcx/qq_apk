package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoEnum;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TVKVideoInfoCheckTime
{
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = 3;
  public static final String TAG = "MediaPlayerMgr[TVKVideoInfoCheckTime]";
  private static TVKVideoInfoCheckTime mCheckTime;
  public static long mElapsedRealTime = 0L;
  public static String mRandKey = "";
  public static long mServerTime;
  private ITVKHttpProcessor.ITVKHttpCallback mCheckTimeCb = new TVKVideoInfoCheckTime.1(this);
  private int mCurrentHostUrlRetryCount = 0;
  private boolean mIsSuccess = false;
  private int mRetryTime = 0;
  private boolean mRetryWithoutHttps = false;
  private boolean mUseBkurl = false;
  private long mstartRequestMS = 0L;
  
  private void executeRequest()
  {
    boolean bool = this.mUseBkurl;
    if ((!bool) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT))
    {
      this.mUseBkurl = (bool ^ true);
      this.mCurrentHostUrlRetryCount = 0;
    }
    int i = this.mCurrentHostUrlRetryCount;
    if (i < CURRENT_HOST_URL_RETRY_MAX_COUNT)
    {
      this.mCurrentHostUrlRetryCount = (i + 1);
      this.mRetryTime += 1;
      Map localMap = getRequestParams();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[VideoInfo][checkTime] request time:");
      localStringBuilder.append(this.mCurrentHostUrlRetryCount);
      TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", localStringBuilder.toString());
      this.mstartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getCheckTimeUrl(), localMap, getHeaders(), this.mCheckTimeCb);
      return;
    }
    reset();
  }
  
  private String getCheckTimeUrl()
  {
    String str1;
    if (this.mUseBkurl) {
      str1 = TVKVideoInfoEnum.CHECK_TIEM_BK_SERVER;
    } else {
      str1 = TVKVideoInfoEnum.CHECK_TIEM_SERVER;
    }
    String str2 = str1;
    if (!this.mRetryWithoutHttps)
    {
      str2 = str1;
      if (TVKVideoInfoConfig.getInstance().isEnableHttps()) {
        str2 = str1.replaceFirst("http", "https");
      }
    }
    return str2;
  }
  
  private Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", "qqlive");
    return localHashMap;
  }
  
  public static TVKVideoInfoCheckTime getInstance()
  {
    try
    {
      TVKVideoInfoCheckTime localTVKVideoInfoCheckTime = TVKVideoInfoCheckTime.SingletonHolder.access$100();
      return localTVKVideoInfoCheckTime;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private Map<String, String> getRequestParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("otype", "xml");
    localHashMap.put("rand", String.valueOf(Math.random()));
    return localHashMap;
  }
  
  private boolean parseResponseXml(String paramString)
  {
    try
    {
      Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
      paramString = ((Document)localObject2).getElementsByTagName("s");
      localObject1 = ((Document)localObject2).getElementsByTagName("t");
      localObject2 = ((Document)localObject2).getElementsByTagName("rand");
      if ((paramString.getLength() > 0) && (((NodeList)localObject1).getLength() > 0) && (((NodeList)localObject2).getLength() > 0) && (paramString.item(0).getFirstChild().getNodeValue().equals("o")))
      {
        mServerTime = TVKUtils.optLong(((NodeList)localObject1).item(0).getFirstChild().getNodeValue(), 0L);
        mRandKey = ((NodeList)localObject2).item(0).getFirstChild().getNodeValue();
        mElapsedRealTime = SystemClock.elapsedRealtime();
        paramString = new StringBuilder();
        paramString.append("[VideoInfo][TVKCGICheckTime]serverTime:");
        paramString.append(mServerTime);
        paramString.append(" randKey:");
        paramString.append(mRandKey);
        paramString.append(" elapsedRealTime:");
        paramString.append(mElapsedRealTime);
        TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", paramString.toString());
        this.mIsSuccess = true;
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[VideoInfo][checkTime]parse xml error:");
      ((StringBuilder)localObject1).append(paramString.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private void reset()
  {
    this.mRetryTime = 0;
    this.mUseBkurl = true;
    this.mstartRequestMS = 0L;
    this.mCurrentHostUrlRetryCount = 0;
  }
  
  public boolean getIsSuccess()
  {
    return this.mIsSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCheckTime
 * JD-Core Version:    0.7.0.1
 */