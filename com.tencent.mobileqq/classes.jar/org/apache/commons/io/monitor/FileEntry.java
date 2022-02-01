package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

public class FileEntry
  implements Serializable
{
  static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
  private static final long serialVersionUID = -2505664948818681153L;
  private FileEntry[] children;
  private boolean directory;
  private boolean exists;
  private final File file;
  private long lastModified;
  private long length;
  private String name;
  private final FileEntry parent;
  
  public FileEntry(File paramFile)
  {
    this(null, paramFile);
  }
  
  public FileEntry(FileEntry paramFileEntry, File paramFile)
  {
    if (paramFile != null)
    {
      this.file = paramFile;
      this.parent = paramFileEntry;
      this.name = paramFile.getName();
      return;
    }
    throw new IllegalArgumentException("File is missing");
  }
  
  public FileEntry[] getChildren()
  {
    FileEntry[] arrayOfFileEntry = this.children;
    if (arrayOfFileEntry != null) {
      return arrayOfFileEntry;
    }
    return EMPTY_ENTRIES;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public long getLastModified()
  {
    return this.lastModified;
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public int getLevel()
  {
    FileEntry localFileEntry = this.parent;
    if (localFileEntry == null) {
      return 0;
    }
    return localFileEntry.getLevel() + 1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public FileEntry getParent()
  {
    return this.parent;
  }
  
  public boolean isDirectory()
  {
    return this.directory;
  }
  
  public boolean isExists()
  {
    return this.exists;
  }
  
  public FileEntry newChildInstance(File paramFile)
  {
    return new FileEntry(this, paramFile);
  }
  
  public boolean refresh(File paramFile)
  {
    boolean bool3 = this.exists;
    long l3 = this.lastModified;
    boolean bool4 = this.directory;
    long l4 = this.length;
    this.name = paramFile.getName();
    this.exists = paramFile.exists();
    boolean bool1 = this.exists;
    boolean bool2 = true;
    if ((bool1) && (paramFile.isDirectory())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.directory = bool1;
    bool1 = this.exists;
    long l2 = 0L;
    if (bool1) {
      l1 = paramFile.lastModified();
    } else {
      l1 = 0L;
    }
    this.lastModified = l1;
    long l1 = l2;
    if (this.exists)
    {
      l1 = l2;
      if (!this.directory) {
        l1 = paramFile.length();
      }
    }
    this.length = l1;
    bool1 = bool2;
    if (this.exists == bool3)
    {
      bool1 = bool2;
      if (this.lastModified == l3)
      {
        bool1 = bool2;
        if (this.directory == bool4)
        {
          if (this.length != l4) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void setChildren(FileEntry[] paramArrayOfFileEntry)
  {
    this.children = paramArrayOfFileEntry;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.directory = paramBoolean;
  }
  
  public void setExists(boolean paramBoolean)
  {
    this.exists = paramBoolean;
  }
  
  public void setLastModified(long paramLong)
  {
    this.lastModified = paramLong;
  }
  
  public void setLength(long paramLong)
  {
    this.length = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.monitor.FileEntry
 * JD-Core Version:    0.7.0.1
 */