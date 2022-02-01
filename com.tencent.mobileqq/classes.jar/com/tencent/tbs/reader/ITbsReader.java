package com.tencent.tbs.reader;

public abstract interface ITbsReader
{
  public static final int OPEN_FILEREADER_ASYNC_LOAD_READER_ENTRY_CALLBACK = 16;
  public static final int OPEN_FILEREADER_CORE_CALLBACK = 14;
  public static final int OPEN_FILEREADER_ERRORCODE_CAN_NOT_OPEN = 10000;
  public static final int OPEN_FILEREADER_ERRORCODE_CAN_NOT_SUPPORTED = 10001;
  public static final int OPEN_FILEREADER_ERRORCODE_PERMISSION_DENIED = 20001;
  public static final int OPEN_FILEREADER_MINIQB_CALLBACK = 13;
  public static final int OPEN_FILEREADER_OPEN_SUCCESS = 0;
  public static final int OPEN_FILEREADER_PLUGIN_FAILED = 11;
  public static final int OPEN_FILEREADER_PLUGIN_PROGRESS = 12;
  public static final int OPEN_FILEREADER_PLUGIN_SUCCESS = 10;
  public static final int OPEN_FILEREADER_STATUS_UI_CALLBACK = 15;
  public static final int TBS_READER_TYPE_MIXER = 3;
  public static final int TBS_READER_TYPE_ONLY_VIEW = 1;
  
  public abstract Object createAtom(int paramInt);
  
  public abstract void destroy();
  
  public abstract void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2);
  
  public abstract ITbsReader.IReaderCore getReaderCore();
  
  public abstract ITbsReader.IReaderPlugin getReaderPlugin();
  
  public abstract void registerAtom(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ITbsReader
 * JD-Core Version:    0.7.0.1
 */