package com.tencent.mobileqq.text;

import android.text.Spannable;
import com.tencent.mobileqq.app.HardCodeUtil;

public abstract class AbsQQText
  implements Spannable, CharSequence
{
  public static final int AIO_NICK_EMO_SIZE = 13;
  public static final int DEFAULT_BIG_EMO_SIZE = 32;
  public static final int DEFAULT_EMO_SIZE = 32;
  public static final String EMOJI_SYMBOL = HardCodeUtil.a(2131699599);
  public static final int EMOJI_TYPE_EMOJI = 0;
  public static final int EMOJI_TYPE_SMALL = 2;
  public static final int EMOJI_TYPE_SYSTEM = 1;
  public static final char ENTER = '\r';
  public static final char ENTER_REPLACE = 'þ';
  public static final int GRAB_ANIM_EMOTCATION = 5;
  public static final int GRAB_EMOJI = 1;
  public static final int GRAB_EMOTCATION = 3;
  public static final int GRAB_EMOTCATION_MASK = 7;
  public static final int GRAB_FOR_AIO = 13;
  public static final int GRAB_LINKS = 8;
  public static final int GRAB_SYS_ANIM_EMOTCATION = 4;
  public static final int GRAB_SYS_EMOTCATION = 2;
  public static final int GRAB_SYS_EMOTCATION_MASK = 6;
  public static final char HEAD_INDEX = '\024';
  public static final char HEAD_INDEX_REPLACE = 'ý';
  public static final char LF = '\n';
  public static final int NO_ACTION = 0;
  public static final int PLAIN_TYPE_FILTER_SYS_AND_EMOJI = 1;
  public static final int PLAIN_TYPE_REPLACE_EMOJI = 2;
  public static final int PLAIN_TYPE_RETAIN_EMOJI = 3;
  public static final char RF = 'ú';
  public static String SMALL_EMOJI_SYMBOL = HardCodeUtil.a(2131699600);
  public static final int SMALL_EMO_SIZE = 16;
  public static final int SUB_SEQUENCE_FLAG_PASS_FLAGS = 1;
  public static final int TROOP_NICK_EDIT_EMO_SIZE = 16;
  
  public abstract AbsQQText append(String paramString, boolean paramBoolean, int... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.AbsQQText
 * JD-Core Version:    0.7.0.1
 */