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
  private static final String TAG = "MediaPlayerMgr[TVKVideoInfoCheckTime]";
  private static TVKVideoInfoCheckTime mCheckTime;
  public static long mElapsedRealTime;
  public static String mRandKey;
  public static long mServerTime = 0L;
  private ITVKHttpProcessor.ITVKHttpCallback mCheckTimeCb = new TVKVideoInfoCheckTime.1(this);
  private int mCurrentHostUrlRetryCount = 0;
  private boolean mIsSuccess = false;
  private int mRetryTime = 0;
  private boolean mRetryWithoutHttps = false;
  private boolean mUseBkurl = false;
  private long mstartRequestMS = 0L;
  
  static
  {
    mElapsedRealTime = 0L;
    mRandKey = "";
  }
  
  private void executeRequest()
  {
    if ((!this.mUseBkurl) && (this.mCurrentHostUrlRetryCount == CURRENT_HOST_URL_RETRY_MAX_COUNT)) {
      if (this.mUseBkurl) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      this.mUseBkurl = bool;
      this.mCurrentHostUrlRetryCount = 0;
      if (this.mCurrentHostUrlRetryCount >= CURRENT_HOST_URL_RETRY_MAX_COUNT) {
        break;
      }
      this.mCurrentHostUrlRetryCount += 1;
      this.mRetryTime += 1;
      Map localMap = getRequestParams();
      TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", "[VideoInfo][checkTime] request time:" + this.mCurrentHostUrlRetryCount);
      this.mstartRequestMS = SystemClock.elapsedRealtime();
      TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, getCheckTimeUrl(), localMap, getHeaders(), this.mCheckTimeCb);
      return;
    }
    reset();
  }
  
  private String getCheckTimeUrl()
  {
    if (this.mUseBkurl) {}
    for (String str1 = TVKVideoInfoEnum.CHECK_TIEM_BK_SERVER;; str1 = TVKVideoInfoEnum.CHECK_TIEM_SERVER)
    {
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
      Object localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
      paramString = ((Document)localObject).getElementsByTagName("s");
      NodeList localNodeList = ((Document)localObject).getElementsByTagName("t");
      localObject = ((Document)localObject).getElementsByTagName("rand");
      if ((paramString.getLength() > 0) && (localNodeList.getLength() > 0) && (((NodeList)localObject).getLength() > 0) && (paramString.item(0).getFirstChild().getNodeValue().equals("o")))
      {
        mServerTime = TVKUtils.optLong(localNodeList.item(0).getFirstChild().getNodeValue(), 0L);
        mRandKey = ((NodeList)localObject).item(0).getFirstChild().getNodeValue();
        mElapsedRealTime = SystemClock.elapsedRealtime();
        TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", "[VideoInfo][TVKCGICheckTime]serverTime:" + mServerTime + " randKey:" + mRandKey + " elapsedRealTime:" + mElapsedRealTime);
        this.mIsSuccess = true;
        return true;
      }
    }
    catch (Exception paramString)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKVideoInfoCheckTime]", "[VideoInfo][checkTime]parse xml error:" + paramString.toString());
      return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoCheckTime
 * JD-Core Version:    0.7.0.1
 */