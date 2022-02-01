package com.tencent.mobileqq.editor.composite;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class CodecParam
{
  public static final int AUDIO_SAMPLE_16K = 16000;
  public static final int AUDIO_SAMPLE_44DOT1K = 44100;
  public static final int AUDIO_SAMPLE_8K = 8000;
  public static final int AUDIO_START_TIME_RATIO_INIT = 65537;
  public static final int BITRATE_MODE_CBR = 1;
  public static final int BITRATE_MODE_VBR = 0;
  public static final int DEFAULT_ADJUST_SPECIAL_SPEED = 1;
  public static final int DEFAULT_CRF_VALUE = 23;
  public static int DST_VIDEO_HEIGHT = 360;
  public static int DST_VIDEO_WIDTH = 480;
  public static int FINAL_DST_VIDEO_HEIGHT = 240;
  public static int FINAL_DST_VIDEO_WIDTH = 320;
  public static final String PARAM_AUDIO_CHANNEL = "audio_channel";
  public static final String PARAM_AUDIO_SAMPLERATE = "audio_samplerate";
  public static final String PARAM_CUR_TYPE = "curType";
  public static final String PARAM_SYNC_STORY_CHECKED = "sync_story_checked";
  public static int RECORD_MAX_TIME = 8000;
  public static int RECORD_MIN_TIME = 2000;
  public static final int SAVE_BACK_MODE = 5;
  public static final int SAVE_BLACK_WHITE_FILTER_MODE = 9;
  public static final int SAVE_BRIGHT_FILTER_MODE = 6;
  public static final int SAVE_COLD_FILTER_MODE = 8;
  public static final int SAVE_FAST_MODE = 1;
  public static final int SAVE_LITTLE_FAST_MODE = 3;
  public static final int SAVE_LOMO_FILTER_MODE = 7;
  public static final int SAVE_MODE_INDEX = 15;
  public static final int SAVE_NORMAL_MODE = 0;
  public static final int SAVE_SLOW_MODE = 2;
  public static final int SAVE_VERY_SLOW_MODE = 4;
  public static int SEGMENT_RECORD_MAX_TIME = 20000;
  public static int VIDEO_FPS = 30;
  public static int VIDEO_RATIO_DEN = 3;
  public static int VIDEO_RATIO_MOL = 2;
  public static int mAdjustSpecialSpeed = 1;
  public static int mAudioChannel = 16;
  public static int mAudioFormat = 2;
  public static int mAudioSampleRate = 44100;
  public static int mAudioTimeRatio = 65537;
  public static int mAudioTimestampHigh = 0;
  public static int mAudioTimestampLow = 0;
  public static int mBitrateMode = 0;
  public static int mCRFValue = 23;
  public static int mCodecId = 0;
  public static int mDstAudioEncBitrate = 64000;
  public static int mDstVideoEncBitrate = 500000;
  private static int mEnableBaseLineMp4 = 0;
  public static int mEnableTimestampFix = 0;
  public static int mEnableTotalTimeAdjust = 0;
  public static int mGopSize = 300;
  public static int mIFrameInterval = 10;
  public static int mIsSmooth = 1;
  public static int mMaxQdiff = 3;
  public static int mMaxrate = 450000;
  public static int mMinrate = 100000;
  public static int mQmax = 31;
  public static int mQmin = 1;
  public static int mRecordFrames = 1;
  public static int mRecordTime = 1000;
  public static int mRefframe = 1;
  public static int mSaveMode = 0;
  public static int mVersion = 1;
  
  public static int[] getConfigParam()
  {
    if (VideoEnvironment.getAVCodecSupportFeature(5)) {
      return new int[] { mMaxrate, mMinrate, mQmax, mQmin, mMaxQdiff, mRefframe, mIsSmooth, mRecordTime, mRecordFrames, mEnableTotalTimeAdjust, mEnableTimestampFix, mAudioTimestampLow, mAudioTimestampHigh, mAudioTimeRatio, mEnableBaseLineMp4, mSaveMode, mBitrateMode, mGopSize, mCRFValue, mAdjustSpecialSpeed };
    }
    return new int[] { mMaxrate, mMinrate, mQmax, mQmin, mMaxQdiff, mRefframe, mIsSmooth, mRecordTime, mRecordFrames };
  }
  
  public static void initFixTimestampSwitch()
  {
    mEnableTimestampFix = 0;
    mAudioTimestampLow = 0;
    mAudioTimestampHigh = 0;
    mAudioTimeRatio = 65537;
  }
  
  public static void setEnableBaseLineMp4Flag(boolean paramBoolean)
  {
    mEnableBaseLineMp4 = 0;
    if (paramBoolean) {
      mEnableBaseLineMp4 = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.CodecParam
 * JD-Core Version:    0.7.0.1
 */